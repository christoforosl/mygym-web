package org.common.api.query.sqlbuilders;

import org.common.api.query.Criterion;
import org.common.api.query.QueryStatement;



/**
 *
 * @author christoforosl
 */
public interface ICriterionSQLBuilder {

	public static final String PARAM_MARKER = "?";
	public static final String SINGLE_SPACE = " ";
	/**
	 *
	 * @param stmt
	 * @param cr
	 */
	public abstract void buildSQLCondition(final QueryStatement stmt, final Criterion cr);
	
}
