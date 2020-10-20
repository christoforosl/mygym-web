package org.common.api.query;

import org.common.api.query.sqlbuilders.CriterionSQLBuilder;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author christoforosl
 */
public class CustomCriteria {
	
	private final Map<String, Class<? extends CriterionSQLBuilder>> customCriteria = new HashMap<>();
	
	private static CustomCriteria instance;
	
	private CustomCriteria() {
		
	}
	
	public static CustomCriteria current() {
		if(instance==null) {
			instance=new CustomCriteria();
		}
		return instance;
	}
	
	public void addCustomCriterion(String key, Class<? extends CriterionSQLBuilder> x) {
		customCriteria.put( key, x );
	}
	
	public CriterionSQLBuilder getCustomCriterionBuilder(String key) {
		if (customCriteria.containsKey(key )) {
			Class<? extends CriterionSQLBuilder> x = customCriteria.get(key);
			try {
				return x.newInstance();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		} else {
			return null;
		}
	}
}
