package org.common.api.base;

import com.netu.lib.Model.ModelObject;
import com.netu.lib.Model.annotations.MOColumn;
import com.netu.lib.NetuUtils;
import org.common.api.query.Criterion;
import org.common.api.query.EnumCondition;
import org.common.api.query.EnumCriterionType;
import org.common.api.query.EnumOperator;
import org.common.api.query.QueryCriteria;
import org.common.api.query.QuerySort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author chris
 */
public class QueryCriteriaParser {

	private static final Logger LOGGER = Logger.getLogger(QueryCriteriaParser.class.getName());
	
	private static final String PARAM_L = "l";
	private static final String PARAM_F = "f";
	private static final String PARAM_FO = "fo";
	private static final String PARAM_S = "s";
	private static final String PARAM_Q = "q";
	private static final String PARAM_PREDEFINED_QUERY = "pq";
	private static final String PARAM_SKIP = "sk";
	
	private Map<String, String> jsonReq;
	private Class<? extends ModelObject> modelClass;
	private List<MOColumn> columns = new ArrayList<>();
	private static Properties predefinedQueries;
	
	public static Properties getPredefinedQueriesProperties() {
		if(predefinedQueries == null) {
			predefinedQueries = NetuUtils.getProperties("predefinedQueries.properties");
		}
		
		return predefinedQueries;
		
	}

	public QueryCriteriaParser setModelClass(Class<? extends ModelObject> modelClass) {
		this.modelClass = modelClass;
		this.columns = ModelObject.classColumnList(this.modelClass);
		return this;
	}

	public QueryCriteriaParser setQueryMap(Map jsonReq) {
		this.jsonReq = jsonReq;
		return this;
	}

	public boolean optBoolean(final String key, boolean idefault) {
		String strValue = jsonReq.get(key);
		boolean ret = idefault;
		if( StringUtils.isNotBlank(strValue) ) {
			try {
				ret = Boolean.valueOf(strValue);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE,"optBoolean error", e);
			}
		}
		return ret;
	}

	public int optInt(final String key, int idefault) {
		final String strValue = jsonReq.get(key);
		int ret = idefault;
		if( StringUtils.isNotBlank(strValue) ) {
			try {
				ret = Integer.parseInt(strValue);
			} catch (NumberFormatException e) {
				LOGGER.log(Level.SEVERE,"optInt error", e);
			}
		}
		
		return ret;
	}
	
	/**
	 * Parse mongo-style parameters into sql parameters 
	 * Example: q=%7BaudioMediaId:210%7D&s=%7BstartMilliseconds:1%7D
	 * @return QueryCriteria object
	 */
	public QueryCriteria parseQueryParameters() {

		final QueryCriteria q = new QueryCriteria();
		final int jPageSize = this.optInt(PARAM_L, 1000); // that's a lower case l
		q.setPageSize(jPageSize);

		// f=<set of fields> - specify the set of fields to include or exclude in each document (1 - include; 0 - exclude)
		// f={"firstName": 1, "lastName": 1}
		// note: we also support comma delimited fields!
		if( this.jsonReq.containsKey(PARAM_F)) {
			final JSONObject fields = this.optJSONObject(PARAM_F);
			if (fields == null) {
				// case where we just give fields as comma delimited list
				q.setSelectFields( StringUtils.split(this.jsonReq.get(PARAM_F),','));
			} else {
				List<String> flds = new ArrayList<>();
				for (String skey : fields.keySet()) {
					flds.add(skey);
				}
				q.setSelectFields(flds.toArray(new String[flds.size()]));
			}
		
		}
		
		if (this.optBoolean(PARAM_FO, false)) {
			//fo=true - return a single document from the result set (same as findOne() using the mongo shell
			q.setPageNumber(1);
			q.setPageSize(1);
		}

		//s=<sort order> - specify the order in which to sort each specified field (1- ascending; -1 - descending)
		// s={"priority": 1, "difficulty": -1}
		final JSONObject sort = this.optJSONObject(PARAM_S);
		if (sort != null) {
			int seq = 1;
			final List<QuerySort> sorts = new ArrayList<>();
			
			// the keyset returns the sort fields in reverse order 
			// ie, if you have s={"createDate": 1, "title": -1}
			// it will return keys title, createDate,
			// so I am reversing it by decreasing the sequence
			for (final String skey : sort.keySet()) {
				final QuerySort.sortOrder sortKey = QuerySort.sortOrder.fromInt(sort.getInt(skey));
				final String dbFieldName = getDBFieldName(skey);
				sorts.add(new QuerySort( seq++, dbFieldName==null? skey : dbFieldName, sortKey));
			}
			q.setSortFields(sorts);

		}

		//sk=<num results to skip> - specify the number of results to skip in the result set; useful for paging
		final int sk = this.optInt(PARAM_SKIP, 0);
		if (sk > 0) {
			q.setPageNumber((sk / jPageSize) + 1);
		}
		
		final JSONArray query = this.optJSONArray(PARAM_Q);
		final String predefinedQueryPropertyKey = this.jsonReq.get(PARAM_PREDEFINED_QUERY);
		
		Validate.isTrue(  StringUtils.isBlank(predefinedQueryPropertyKey) ||  query==null, 
				"Request parameter cannot have both q and pq parametrs");

		if (StringUtils.isNotBlank(predefinedQueryPropertyKey)) {
			
			final String prefedinedquery = getPredefinedQueriesProperties().getProperty(predefinedQueryPropertyKey);
			Validate.isTrue(StringUtils.isNotBlank(prefedinedquery), String.format( "Key %s not found in predefined queries", predefinedQueryPropertyKey));
			
			//Validate.isTrue(PATTERN_ORDER_BY.matcher(prefedinedquery).find() == false, "Predefined queries cannot contain order by");
			
			final Criterion qc = new Criterion();
			qc.setType(EnumCriterionType.plainText);
			
			qc.setFieldName(prefedinedquery);
			if ( this.jsonReq.containsKey("v") ) {
				qc.setValue(this.jsonReq.get("v")); 
			}
			q.getFilters().add(qc);
			
		}

		
		if (query != null) {

			EnumOperator oper = null;

			for (int i = 0; i < query.length(); i++) {

				final JSONObject jsonFieldCriterion = query.getJSONObject(i);
				final String skey = jsonFieldCriterion.keySet().iterator().next();

				if ((i + 1) % 2 == 0) {
					Validate.isTrue("operator".equals(skey), "Multiple Field criteria must be separated by {operator:$and} or {operator:$or} json objects");
					oper = EnumOperator.forValue(jsonFieldCriterion.getString(skey));
				} else {
					final Criterion parsedCriterion = parseCriterion(jsonFieldCriterion);
					parsedCriterion.setOperator(oper);
					q.getFilters().add(parsedCriterion);
				}
			}
		}

		return q;
	}

	protected Criterion parseCriterion(final JSONObject jsonFieldCriterion) {

		final String skey = jsonFieldCriterion.keySet().iterator().next();
		final Criterion c = new Criterion();
		final String dbFieldName = getDBFieldName(skey);
		c.setFieldName(skey);
		c.setDatabaseFieldName(dbFieldName != null ? dbFieldName : skey );

		final Object objKeyVal = jsonFieldCriterion.get(skey);
		if (objKeyVal instanceof JSONObject) {
			// support mongo expressions https://docs.mongodb.com/v3.2/reference/operator/query/
			final JSONObject innerFierldSpec = (JSONObject) objKeyVal;
			final String innerKey = innerFierldSpec.keySet().iterator().next();
			c.setCondition(EnumCondition.forValue(innerKey));
			c.setValue(String.valueOf(innerFierldSpec.get(innerKey)));

		} else {
			c.setValue(String.valueOf(objKeyVal));
		}
		return c;
	}
	

	private String getDBFieldName(final String skey) {
		// find the database field name from the field name
		for (final MOColumn moc : columns) {
			if (moc.fieldName().equalsIgnoreCase(skey)) {
				return moc.dbFieldName();
			}
		}
		return null;
		
	}
	
	/**
	 * Try to parse "key" parameter into a JSONObject, return null if not parsable
	 *
	 * @param key key of json request
	 * @return JSONObject or null
	 */
	private JSONObject optJSONObject(final String key) {
		
		final String strValue = this.jsonReq.get(key);
		JSONObject ret = null;
		if (StringUtils.isNotBlank(strValue) && strValue.startsWith("{") && strValue.endsWith("}") ) {
			try {
				ret = new JSONObject(strValue);
			} catch (JSONException e) {
				LOGGER.log(Level.SEVERE, String.format( "optJSONObject error for key \"%s\"", key ), e);
			}
		}

		return ret;
	}

	private JSONArray optJSONArray(final String key) {
		String strValue = this.jsonReq.get(key);
		if (StringUtils.isBlank(strValue)) {
			return null;
		}
		if (!strValue.endsWith("]")) {
			strValue = strValue + "]";
		}
		if (!strValue.startsWith("[")) {
			strValue = "[" + strValue;
		}
		JSONArray ret = null;
		try {
			ret = new JSONArray(strValue);
		} catch (JSONException e) {
			LOGGER.log(Level.SEVERE,"optJSONObject error", e);
		}

		return ret;
	}

	 

}
