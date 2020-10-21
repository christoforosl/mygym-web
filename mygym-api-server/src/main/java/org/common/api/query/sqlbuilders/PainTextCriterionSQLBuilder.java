package org.common.api.query.sqlbuilders;

import org.common.api.query.Criterion;
import org.common.api.query.QueryStatement;
import org.apache.commons.lang.StringUtils;


/**
 * Default CriterionSQLBuilder class. It just appends the sql field name with the parameter
 * @author christoforosl
 */
public class PainTextCriterionSQLBuilder implements ICriterionSQLBuilder {

	@Override
	public void buildSQLCondition(final QueryStatement stmt, final Criterion cr) {
		
		final Object[] values = StringUtils.split(cr.getValue(), ",");
		
		stmt.appendToSQL(SINGLE_SPACE + cr.getFieldName() , values );
	
	}

}
