package org.common.api.base;

import com.netu.lib.ApplicationService;

import com.netu.lib.DBUtils;
import com.netu.lib.JsonModelObject;
import com.netu.lib.Model.ModelObject;
import com.netu.lib.Model.ModelObjectList;
import com.netu.lib.Model.annotations.ManagedModelObject;
import com.netu.lib.db.ConnectionPool;
import com.netu.lib.db.DBMapper;
import com.netu.lib.db.SQLStmtsProvider.SQLStatementsProvider;
import com.netu.lib.rest.APIResults;
import com.netu.lib.rest.CrudApiResults;
import com.netu.lib.rest.EnumRestResultStatus;
import com.netu.lib.rest.SearchResults;
import org.common.api.query.CriteriaBuilder;
import org.common.api.query.QueryCriteria;
import org.common.api.query.QueryStatement;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.common.api.web.ApiServicesApp;
/**
 *
 * @author christoforosl
 */
public class BaseResource {
	
	protected static final Logger LOGGER = Logger.getLogger(BaseResource.class.getName());
	
	private static final String API_RESULTS_ERROR_REPORTING = "Error during -{2}- {0}: {1}";
	private static final Map<Class<? extends ModelObject>, Class<? extends IResourcePersistor>> PERSISTORS;
	private static final ArrayList<String> RELOAD_AFTER_SAVE;

	private DBMapper mapper;
	private static final String GET = "get";
	private static final String I_RESOURCE_PERSISTOR = ".IResourcePersistor";

	private static final String SELECT_COUNT_FROM_CLOSE_PAREN = ") x";
	private static final String WHERE = " where ";
	private static final String SELECT_COUNT_FROM = "select count(*) from (";
	private static final String VERSION;
	
	static {
		
		VERSION = ApiServicesApp.HEROKU_RELEASE_VERSION;
		PERSISTORS = new HashMap<>();
		RELOAD_AFTER_SAVE = new ArrayList<>();
		final String tmp = ApplicationService.getNufProperty("reloadObjectsAfterSave");
		final String tmparr[] = StringUtils.splitPreserveAllTokens(tmp, ',');
		if(tmparr != null && tmparr.length > 0) {
			RELOAD_AFTER_SAVE.addAll( new ArrayList<>( Arrays.asList(tmparr)) );
		}
		
	}

	private CriteriaBuilder criteriaHandler;
	private Class<? extends ModelObject> modelClass;

	public BaseResource() {
		this.criteriaHandler = new CriteriaBuilder();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return criteriaHandler;
	}

	public void setCriteriaHandler(final CriteriaBuilder criteriaHandler) {
		this.criteriaHandler = criteriaHandler;
	}

	private int getCount(QueryStatement stmt) throws Exception {

		final StringBuilder sql = new StringBuilder(SELECT_COUNT_FROM);
		sql.append(this.getDBMapper().getSQLStatement(SQLStatementsProvider.SQL_SELECT_ALL));
		sql.append(WHERE).append(stmt.getSqlStatementBuffer()).append(SELECT_COUNT_FROM_CLOSE_PAREN);

		Connection c = null;
		try {
			c = ConnectionPool.getConn();
			return DBUtils.getIntValue(c, sql.toString(), stmt.getParameters().toArray());

		} finally {
			DBUtils.closeQuietly(c);
		}
	}

	/**
	 * Support mongo style queries as per https://docs.mongodb.com/v3.2/reference/operator/query/ and http://docs.mlab.com/data-api/#list-documents
	 *
	 * <pre><code>
	 *  "q" example - return all documents with "audioMediaId" field equals 210:
	 *  http://localhost:9001/api/services/model/marbyl-mongo-query?q=%7BaudioMediaId:210%7D
	 *
	 *	"f" example (include) - return all documents but include only the "StartMilliseconds" and "EndMilliseconds" fields:
	 *	http://marbyl-services-79649.herokuapp.com/api/services/model/marbyl-mongo-query?&f=%7BStartMilliseconds:1,EndMilliseconds:1%7D&q=%7BaudioMediaId:210%7D&s=%7BstartMilliseconds%7D
	 * 
	 *	"f" example (exclude) - return all documents but exclude the "notes" field:
	 *	--- exclude fields not supported
	 *
	 *	"fo" example - return a single document matching "active" field of true:
	 *	--- not supported
	 *
	 *	"s" example - return all documents sorted by "startMilliseconds" ascending and "publishDate" descending:
	 *	http://marbyl-services-79649.herokuapp.com/api/services/model/marbyl-mongo-query?s=%7BstartMilliseconds:1,publishDate:-1%7D
	 *
	 *	"sk" and "l" example - sort by "name" ascending and return 10 documents after skipping 20
	 *	http://marbyl-services-79649.herokuapp.com/api/services/model/marbyl-mongo-query?s=%7BstartMilliseconds:1%7D&sk=20&l=10&apiKey=myAPIKey
	 *
	 * </code>
	 * </pre>
	 *
	 * @param q=&lt;query&gt; - restrict results by the specified JSON query
	 * @param f=&lt;set of fields&gt; - specify the set of fields to include or exclude in each document (1 - include; 0 - exclude)
	 * @param fo=true - return a single document from the result set (same as findOne() using the mongo shell
	 * @param s=&lt;sort order&gt; - specify the order in which to sort each specified field (1- ascending; -1 - descending)
	 * @param sk=&lt;num results to skip&gt; - specify the number of results to skip in the result set; useful for paging
	 * @param l=&lt;limit&gt; - lower case L: specify the limit for the number of results (default is 1000)
	 * @param pq=predefined query definition
	 * @param v=comma delimited values to be passed to predefined query definition as parameters
	 * @return SearchResults
	 * @throws Exception
	 */
	public SearchResults getQueryResults2(final String q, final String f, final String fo, final String s, final String sk, final String l, final String pq, String v) throws Exception {

		Map<String, String> vals = new HashMap<>();
		vals.put("q", q);
		vals.put("f", f);
		vals.put("fo", fo);
		vals.put("s", s);
		vals.put("sk", sk);
		vals.put("l", l);
		vals.put("pq", pq);
		vals.put("v", v);
		final QueryCriteria qr = new QueryCriteriaParser()
				.setModelClass(this.getModelClass())
				.setQueryMap(vals).parseQueryParameters();

		return this.getQueryResults(qr);

	}

	/**
	 * Retrieves a list of Managed ModelObjects that match the QueryCriteria sent by angular We need to set the list of fields to retrieve back.
	 *
	 * @param pQueryCriteria criteria sent by the Angular client site
	 * @return SearchResults object
	 * @throws Exception
	 */
	public SearchResults getQueryResults(final QueryCriteria pQueryCriteria) throws Exception {

		final SearchResults searchResults = new SearchResults();

		// build where clause
		final QueryCriteria queryCriteria = pQueryCriteria == null ? QueryCriteria.DEFAULT : pQueryCriteria;
		final QueryStatement stmt = this.getCriteriaBuilder().buildCriteria(pQueryCriteria);

		try {

			final DBMapper dbMapper = this.getDBMapper();
			final List lst = dbMapper.findPagedResults(
					queryCriteria.getPageNumber(),
					queryCriteria.getPageSize(),
					stmt.getSqlWhereClause(),
					stmt.getParameters().toArray());

			if (queryCriteria.getSelectFields() != null && queryCriteria.getSelectFields().length > 0) {
				List<HashMap> lstRecords = new ArrayList<>();
				for (final Object obj : lst) {
					final ModelObject mo = (ModelObject) obj;
					final HashMap<String, Object> jsonObj = new HashMap<>();

					for (final String selectedField : queryCriteria.getSelectFields()) {
						final String mapKey = selectedField.substring(0, 1).toLowerCase() + selectedField.substring(1);
						jsonObj.put(mapKey, getReflectedFieldValue(selectedField, mo));
					}
					lstRecords.add(jsonObj);
				}
				searchResults.setResults(lstRecords);
			} else {
				searchResults.setResults(lst);
			}

			searchResults.setStatus(EnumRestResultStatus.SUCCESS);
			searchResults.setNumResults(this.getCount(stmt));
			searchResults.setDebugInfo(VERSION + " " + stmt.getSqlWhereClause());
			
		} catch (Exception e) {
			handleAPIError("getQueryResults", this.getModelClass(), e, searchResults);

		} finally {
			//ApplicationService.release();
			// do not do Application.release here, as the serialization
			// of SearchResults will happen asynchronously
		}

		return searchResults;

	}

	private static Method getMethodIgnoreCase(final Class<?> clazz, final String methodName) {

		List<Method> tmp = Arrays.stream(clazz.getMethods())
				.filter(m -> m.getName().equalsIgnoreCase(methodName))
				.collect(Collectors.toList());
		
		return tmp.isEmpty() ? null : tmp.get(0);
	}

	@SuppressWarnings("UseSpecificCatch")
	public static Object getReflectedFieldValue(final String currFldName, final Object mo) {
		
		Object val = null;
		final String methodName = (currFldName.startsWith(GET) || currFldName.toLowerCase().startsWith("is")) ? currFldName: GET + currFldName;
		final Method methodRef = getMethodIgnoreCase(mo.getClass(),methodName );
		
		if (methodRef != null) {
			try {
				val = methodRef.invoke(mo);
			} catch (Exception ex) {
				throw new IllegalStateException( String.format("Error calling method of name \"%s\"", methodRef.getName() ), ex);
			}
		} else {
			throw new IllegalStateException( String.format("Method of name \"%s\" not found, search was case insensitive.", methodName ));
		}
		return val;
	}

	protected CrudApiResults saveAll(final ModelObjectList<? extends ModelObject> list) {
		final CrudApiResults ret = new CrudApiResults();
		try {

			final DBMapper dbMapper = this.getDBMapper();
			dbMapper.saveModelObjectList(list);

			ret.setStatus(EnumRestResultStatus.SUCCESS);
			ret.setResults(list);
			ret.setDebugInfo(VERSION);
			
		} catch (Exception e) {
			handleAPIError("saveAll", this.getModelClass(), e, ret);

		} finally {
			ApplicationService.release();
		}
		return ret;
	}

	protected SearchResults getById(final Object Id) {

		final SearchResults searchResults = new SearchResults();
		Connection c = null;
		try {
			c = ConnectionPool.getConn();
			final DBMapper dbMapper = this.getDBMapper();
			dbMapper.setConnection(c);

			final ModelObject mo = dbMapper.find(Id);
			searchResults.setResults(mo);
			searchResults.setStatus(EnumRestResultStatus.SUCCESS);
			searchResults.setNumResults(mo == null ? 0 : 1);
			searchResults.setDebugInfo(VERSION + "," + this.getModelClass().getName());
			
		} catch (Exception e) {
			handleAPIError("getById", this.getModelClass(), e, searchResults);

		} finally {
			DBUtils.closeQuietly(c);
		}

		return searchResults;
	}
	
	@SuppressWarnings("UseSpecificCatch")
	protected DBMapper getDBMapper() {
		if (mapper == null) {
			try {
				mapper = ApplicationService.getModelObjectMapper(getModelClass());

			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}

		}
		return mapper;
	}

	protected Class<? extends ModelObject> getModelClass() {
		if (modelClass == null) {
			Validate.isTrue(this.getClass().isAnnotationPresent(ManagedModelObject.class),
					"Annotation ManagedModelObject must be present");
			final ManagedModelObject df = (ManagedModelObject) this.getClass().getAnnotation(ManagedModelObject.class);
			this.modelClass = df.modelClass();
		}

		return this.modelClass;
	}

	protected BaseResource setModelClass(Class<? extends ModelObject> clas) {
		this.modelClass = clas;
		return this;
	}

	protected CrudApiResults save(final JsonModelObject mo) {

		final CrudApiResults ret = new CrudApiResults();

		try {
			if ( mo.isDirty() ) {
				final DBMapper dbMapper = this.getDBMapper();
				LOGGER.fine(mo.getDeletedAssociationObjects() != null ? "Found deleted items" : "No deleted Items");

				mo.prepareDeletedItems();
				final IResourcePersistor p = this.getIResourcePersistor();
				if (p != null) {
					p.save(mo);
				} else {
					dbMapper.save(mo);
				}

				ret.setStatus(EnumRestResultStatus.SUCCESS);
				if (RELOAD_AFTER_SAVE.contains( this.getModelClass().getName() )) {
					LOGGER.log(Level.INFO, MessageFormat.format("Reload mo after save:{0}", this.getModelClass().getName()));
					ret.setResults( dbMapper.find( mo.getId() ) ); 
				} else {
					ret.setResults(mo);
				}
			} else {
				LOGGER.log(Level.INFO, MessageFormat.format( "NO save, model object was not dirty:{0}", this.getModelClass().getName()));
				ret.setResults(mo);
			}
			
			ret.setDebugInfo(VERSION);
			
		} catch (Exception e) {
			handleAPIError("save", this.getModelClass(), e, ret);

		} finally {
			// do not do Application.release here, as the serialization
			// of SearchResults will happen asynchronously
		}

		return ret;
	}

	public CrudApiResults lastUpdate() {
		
		final CrudApiResults ret = new CrudApiResults();
		
		try {
			
			final Date dt =  (Date) DBUtils.getValue("select max(update_date) from " + ModelObject.getManagedTable(this.getModelClass()) );
			ret.setResults(dt);
			ret.setStatus(EnumRestResultStatus.SUCCESS);
			ret.setDebugInfo(VERSION);
			
		} catch (Exception e) {
			handleAPIError("delete", this.getModelClass(), e, ret);
		}
		return ret;

	}
	protected CrudApiResults delete(final Object Id) {

		final CrudApiResults ret = new CrudApiResults();
		LOGGER.fine(MessageFormat.format("delete {0} with id:{1}", this.getModelClass().getName(), Id));
		try {

			final DBMapper dbMapper = this.getDBMapper();
			final ModelObject mo = dbMapper.find(Id);
			//Validate.notNull(mo, MessageFormat.format("Unable to find object of type {0} with id: {1} for deletion!", dbMapper.getClass().getName(), Id));
			if( mo != null) {
				dbMapper.delete(mo);
				
			} else {
				final String msg = String.format(
						"WARNING: Object of type %s and id: %s to be deleted not found, request still reported as successfull",
						this.getModelClass().getName(), Id);
				
				ret.setError(msg); 
				LOGGER.info(msg); 
			}
			ret.setResults(mo);
			ret.setStatus(EnumRestResultStatus.SUCCESS);
			ret.setDebugInfo(VERSION);
			
		} catch (Exception e) {
			handleAPIError("delete", this.getModelClass(), e, ret);

		} finally {
			//ApplicationService.release();
		}

		return ret;
	}

	public boolean checkAccess() {
		return true;
	}

	private IResourcePersistor getIResourcePersistor() throws Exception {

		final Class<? extends ModelObject> mdlclaz = this.getModelClass();

		if (!PERSISTORS.containsKey(mdlclaz)) {
			final String persistor = ApplicationService.getNufProperty(mdlclaz.getName() + I_RESOURCE_PERSISTOR);
			if (StringUtils.isNotBlank(persistor)) {
				PERSISTORS.put(mdlclaz, (Class<? extends IResourcePersistor>) Class.forName(persistor));
			} else {
				PERSISTORS.put(mdlclaz, null);
			}
		}
		final Class<? extends IResourcePersistor> claz = PERSISTORS.get(mdlclaz);

		return claz == null ? null : claz.newInstance();

	}

	private static void handleAPIError(final String method, final Class modelClass, final Throwable e, final APIResults res) {

		LOGGER.log(Level.SEVERE, MessageFormat.format(API_RESULTS_ERROR_REPORTING, method, modelClass.getName(), e.getMessage()), e);
		res.setStatus(EnumRestResultStatus.ERROR);
		res.setError(e instanceof NullPointerException ? "NullPointerException" : e.getMessage());

	}

}
