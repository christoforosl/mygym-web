package org.common.api.query.sqlbuilders;

import org.common.api.query.Criterion;
import org.common.api.query.EnumCondition;
import org.common.api.query.QueryStatement;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * Default CriterionSQLBuilder class. It just appends the sql field name with the parameter
 *
 * @author christoforosl
 */
public class CriterionSQLBuilder implements ICriterionSQLBuilder {

	

	@Override
	public void buildSQLCondition(final QueryStatement stmt, final Criterion cr) {

		if (cr.isLikeClause()) {
//			if ( cr.getDataTypeValue().toString().length() < 3 ) {
//				logger.log(Level.FINE,MessageFormat.format("skipped like less than 3:**{0}*", cr.getDataTypeValue()));
//				return;
//			}
		}

		Validate.notEmpty(cr.getDatabaseFieldName(), "cr.getDatabaseFieldName() is null");
		stmt.appendToSQL(cr.getOperator() != null ? cr.getOperator().toString() : StringUtils.EMPTY);
		stmt.appendToSQL(cr.getDatabaseFieldName()).appendToSQL(SINGLE_SPACE);

		switch (cr.getValue()) {
			case Criterion.IS_NULL:
				stmt.appendToSQL(" is null ");
				break;
			case Criterion.IS_NOT_NULL:
				stmt.appendToSQL(" is not null ");
				break;
			default:
				if (cr.getCondition() == EnumCondition.LIKE) {
					stmt.appendToSQL(SINGLE_SPACE)
							.appendToSQL("LIKE CONCAT('%',")
							.appendToSQL(PARAM_MARKER)
							.appendToSQL(",'%')", cr.getDataTypeValue());

				} else
					if (cr.getCondition() == EnumCondition.BLIKE) {
						stmt.appendToSQL(SINGLE_SPACE)
								.appendToSQL("LIKE CONCAT('%'," + PARAM_MARKER + ")", cr.getDataTypeValue());

					} else
						if (cr.getCondition() == EnumCondition.ALIKE) {
							stmt.appendToSQL(SINGLE_SPACE)
									.appendToSQL("LIKE CONCAT(" + PARAM_MARKER + ",'%')", cr.getDataTypeValue());
						} else {
							stmt.appendToSQL(cr.getCondition().toString()).appendToSQL(SINGLE_SPACE)
									.appendToSQL(PARAM_MARKER, cr.getDataTypeValue());

						}

				break;
		}

	}

}
