package org.common.api.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PavlosP
 */
public class QueryStatement {

	private StringBuilder sqlStatementBuffer;
	private List<Object> parameters=new ArrayList<>();
	
	private static final String ONE_EQ_ONE = "1=1 ";
	
	/**
	 * Resets the sql string and the parameters to an empty array list
	 */
	public void reset(){
		this.sqlStatementBuffer = new StringBuilder(ONE_EQ_ONE);
		this.parameters = new ArrayList<>();
	}

	/**
	 * appends to the sql statement with optional parameters.
	 * @param sqlSinppet sql snippet to add, for example "where x = ?"
	 * @param params paremers to be passed to sqlSinppet, variable number
	 * @return self so clients can use fluent api
	 */
	public QueryStatement appendToSQL(final String sqlSinppet, final Object ... params ){
		
		this.sqlStatementBuffer.append(sqlSinppet);
		if(params!=null && params.length>0) {
			this.parameters.addAll(Arrays.asList(params));
		}
		return this;
	}
	
	public QueryStatement appendToSQL(final StringBuilder sqlSinppet, final Object ... params ){
		
		return this.appendToSQL(sqlSinppet.toString(), params);
	}

	public StringBuilder getSqlStatementBuffer() {
		return sqlStatementBuffer;
	}
	
	/**
	 * Converts sqlStatementBuffer to string and Returns it
	 * @return the sql statement as string
	 */
	public String getSqlWhereClause() {
		return sqlStatementBuffer.toString();
	}

	public void setSqlStatementBuffer(StringBuilder sqlStatementBuffer) {
		this.sqlStatementBuffer = sqlStatementBuffer;
	}

	public List<Object> getParameters() {
		return parameters;
	}

	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}


}
