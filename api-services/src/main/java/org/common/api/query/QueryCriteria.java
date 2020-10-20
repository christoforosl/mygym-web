package org.common.api.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author christoforosl
 */
public class QueryCriteria implements Serializable {
	
	public static QueryCriteria DEFAULT = new QueryCriteria();
	
	private String entityName;
	private int pageNumber = 1;
	private int pageSize = 1000;
	
	private String criteriaConfig;
	private List<QuerySort> sortFields;
	private String[] selectFields;
	private List<Criterion> filters;
	 
	public String getCriteriaConfig() {
		return criteriaConfig;
	}

	public void setCriteriaConfig(final String criteriaConfigKey) {
		this.criteriaConfig = criteriaConfigKey;
	}
	
	public String[] getSelectFields() {
		return selectFields;
	}

	public void setSelectFields(String[] selectFields) {
		this.selectFields = selectFields;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<QuerySort> getSortFields() {
		if(sortFields!=null){
			Collections.sort(sortFields);
		}
		return sortFields;
	}

	public void setSortFields(List<QuerySort> sortField) {
		this.sortFields = sortField;
	}

	public List<Criterion> getFilters() {
		if(filters==null){
			filters = new ArrayList<>();
			
		}
		
		//Collections.sort(filters);
		return filters;
	}

	public void setFilters(List<Criterion> filters) {
		this.filters = filters;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	
}
