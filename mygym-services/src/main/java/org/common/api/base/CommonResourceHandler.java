package org.common.api.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygym.model.base.JsonModelObject;
import com.netu.lib.ApplicationService;

import com.netu.lib.DBUtils;
import com.netu.lib.db.ConnectionPool;
import com.netu.lib.rest.CrudApiResults;
import com.netu.lib.rest.EnumRestResultStatus;
import com.netu.lib.rest.SearchResults;
import static org.common.api.base.QueryCriteriaParser.getPredefinedQueriesProperties;
import org.common.api.query.QueryCriteria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.common.api.web.ApiServicesApp;


import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

/**
 *
 * @author christoforosl
 */
@Path("/services")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class CommonResourceHandler extends BaseResource {

	private static final String MODEL_OBJECT_KEY = "modelObjectKey";

	public static final CrudApiResults CRUD_API_RESULTS_FAILED;
	private static final String SLASH = "/";

	private static final Map<String, Class<? extends JsonModelObject>> MO_KEYS = new ServicesRegister().scanAndRegisterClasses();
	
	static {

		
		CRUD_API_RESULTS_FAILED = new CrudApiResults();
		CRUD_API_RESULTS_FAILED.setStatus(EnumRestResultStatus.ERROR);

	}

	@POST
	@Path("model/{modelObjectKey}")
	public CrudApiResults Save(@PathParam(MODEL_OBJECT_KEY) final String modelObjectKey, final String mo) {

		final Class<? extends JsonModelObject> clas = getManagedClass(modelObjectKey);

		final ObjectMapper mp = new ObjectMapper();
		JsonModelObject mobj;
		try {

			LOGGER.log(Level.FINE, String.format("received object json:\n%s\n-----", mo));

			mobj = mp.readValue(mo, clas);

		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, String.format("error de serializing object \"%s\"", modelObjectKey), ex);
			final CrudApiResults ret = CRUD_API_RESULTS_FAILED;
			ret.setError(ex.toString());
			return ret;
		}
		return this.setModelClass(clas).save(mobj);

	}

	protected Class<? extends JsonModelObject> getManagedClass(final String modelObjectKey) {

		Validate.isTrue(MO_KEYS.containsKey(modelObjectKey.toLowerCase()), String.format("modelObjectKey \"%s\" does not exist in modelObjectKeys", modelObjectKey.toLowerCase()));
		final Class<? extends JsonModelObject> clas = MO_KEYS.get(modelObjectKey.toLowerCase());
		return clas;
	}

	/**
	 * Returns the latest update date of records in the table
	 *
	 * @param modelObjectKey the modelobject key
	 * @return date
	 */
	@GET
	@Path("model/{modelObjectKey}-lastUpdate")
	public CrudApiResults lastUpdate(@PathParam(MODEL_OBJECT_KEY) final String modelObjectKey) {

		return this.setModelClass(getManagedClass(modelObjectKey)).lastUpdate();

	}

	@GET
	@Path("model/{modelObjectKey}/{Id}")
	public SearchResults getObjectById(@PathParam(MODEL_OBJECT_KEY) final String modelObjectKey, final @PathParam("Id") Long Id) {

		return this.setModelClass(getManagedClass(modelObjectKey)).getById(Id);
	}

	@POST
	@Path("model/{modelObjectKey}/query")
	public SearchResults query(@PathParam(MODEL_OBJECT_KEY) final String modelObjectKey, final QueryCriteria criteria) throws Exception {

		final Class<? extends JsonModelObject> clas = getManagedClass(modelObjectKey);
		return this.setModelClass(clas).getQueryResults(criteria);
	}

	@DELETE
	@Path("model/{modelObjectKey}/{Id}")
	public CrudApiResults delete(@PathParam(MODEL_OBJECT_KEY) final String modelObjectKey, @PathParam("Id") Long Id) {

		return this.setModelClass(getManagedClass(modelObjectKey)).delete(Id);

	}

	/**
	 * example test url: http://localhost:9001/api/services/model/MarbylCategory-mongo-query?pq=category.topLevel&s=%7BCategoryNameEn%3A1%7D&f=Id%2CCategoryNameEn Support mongo
	 * style queries as per https://docs.mongodb.com/v3.2/reference/operator/query/ and http://docs.mlab.com/data-api/#list-documents
	 *
	 * @param modelObjectKey the modelobject key
	 * @param q restrict results by the specified JSON query
	 * @param f specify the set of fields to include or exclude in each document (1 - include; 0 - exclude), example :f=field1,field2,field3
	 * @param fo if true, return a single document/record from the result set (same as findOne() using the model mapper
	 * @param s specify the order in which to sort each specified field (1- ascending; -1 - descending), example: s={"priority": 1, "difficulty": -1}
	 * @param sk specify the number of results to skip in the result set; useful for paging
	 * @param l (lower case L) specify the limit for the number of results (default is 1000)
	 * @param pq specify predefined query string key, defined in predefinedQueries.properties
	 * @param v specify value to be passed as parameter to predefined query (only relevant with pq parameter)
	 * @return SearchResults
	 * @throws Exception
	 */
	@GET
	@Path("model/{modelObjectKey}-mongo-query")
	public SearchResults getQueryResults2(@PathParam(MODEL_OBJECT_KEY) final String modelObjectKey,
			@DefaultValue("") @QueryParam("q") String q,
			@DefaultValue("") @QueryParam("f") String f,
			@DefaultValue("") @QueryParam("fo") String fo,
			@DefaultValue("") @QueryParam("s") String s,
			@DefaultValue("") @QueryParam("sk") String sk, // skip records
			@DefaultValue("") @QueryParam("l") String l,
			@DefaultValue("") @QueryParam("pq") String pq,
			@DefaultValue("") @QueryParam("v") String v
	) throws Exception {

		return this.setModelClass(getManagedClass(modelObjectKey)).getQueryResults2(q, f, fo, s, sk, l, pq, v);

	}

	/**
	 * api/services/pq/audiolength/1
	 *
	 * @param pq
	 * @param path
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("do/{pq}{path:.*}")
	public SearchResults getPredefinedQueryResultsFromDoPerefix(
			@PathParam("pq") String pq,
			@PathParam("path") String path) throws Exception {

		return this.getPredefinedQueryResults(pq, path);

	}

	/**
	 * api/services/pq/audiolength/1
	 *
	 * @param pq
	 * @param path
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("pq/{pq}{path:.*}")
	public SearchResults getPredefinedQueryResults(
			@PathParam("pq") String pq,
			@PathParam("path") String path) throws Exception {

		final SearchResults ret = new SearchResults();
		Connection conn = null;
		final String prefedinedquery = getPredefinedQueriesProperties().getProperty(pq);

		try {

			Validate.isTrue(StringUtils.isNotBlank(prefedinedquery), String.format("Key %s not found in predefined queries", pq));

			conn = ConnectionPool.getConn();
			final String xpath = (path.startsWith(SLASH)) ? path.substring(1) : path;
			final Object[] params = xpath.length() > 0 ? (Object[]) xpath.split(SLASH) : null;
			final QueryRunner query = new QueryRunner();
			final List mapList;

			if (params != null && params.length > 0) {
				mapList = (List) query.query(conn, prefedinedquery, new MapListHandler(), params);
			} else {
				mapList = (List) query.query(conn, prefedinedquery, new MapListHandler());
			}

			ret.setResults(mapList);
			ret.setStatus(EnumRestResultStatus.SUCCESS);
			ret.setNumResults(mapList.size());
			ret.setDebugInfo(prefedinedquery);

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, String.format("Error executing sql \"%s\" with key \"%s\"", prefedinedquery, pq), e);
			ret.setStatus(EnumRestResultStatus.ERROR);
			ret.setError(e.getMessage());
		} finally {
			DBUtils.closeQuietly(conn);
		}
		return ret;

	}

	@GET
	@Path(value = "doService/{serviceKey}{path:.*}")
	public SearchResults doMobileObjectOrientedActionApi(@PathParam(value = "serviceKey") final String serviceKey, @PathParam(value = "path") final String path) throws Exception {
		return new PredefinedServicesExecutor().runActionApi(serviceKey, path);
	}

}
