package org.common.api.query.sqlbuilders;

import org.common.api.query.Criterion;
import org.common.api.query.QueryStatement;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;


/**
 *
 * @author christoforosl
 */
public class SubqueryCriterionSQLbuilder implements ICriterionSQLBuilder {

	private static final Properties props;

	static {
		props = new Properties();
		try (InputStream istrm = SubqueryCriterionSQLbuilder.class.getClassLoader().getResourceAsStream("subqueries.properties")) {
			Validate.notNull(istrm, "subqueries.properties file not found");
			props.load(istrm); 
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private String subquerySql;

	public void setSubquerySQLKey(final String key) {
		Validate.notNull(key,"setSubquerySQLKey: key is null");
		this.subquerySql = props.getProperty(key);
		Validate.notEmpty(this.subquerySql, SUBQUERY_SQL_IS_BLANK_FOR_KEY + key);
	}
	private static final String SUBQUERY_SQL_IS_BLANK_FOR_KEY = "subquerySql is blank for key:";

	@Override
	public void buildSQLCondition(final QueryStatement stmt, final Criterion cr) {
		
		final Object[] params = StringUtils.split(cr.getValue(), COMMA);
		final String sql ;
		if(params!=null){
			sql = this.subquerySql.replace(PLACEHOLDER, preparePlaceHolders(params.length));
		} else {
			sql = this.subquerySql.replace(PLACEHOLDER, StringUtils.EMPTY);
		}
		stmt.appendToSQL(sql, params);
		
	}
	private static final String PLACEHOLDER = "__placeholder__";

	public static String preparePlaceHolders(int length) {
		if (length > 0) {
			final StringBuilder builder = new StringBuilder(length * 2 - 1);
			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(COMMA);
				}
				builder.append(QUESTION_MARK);
			}
			return builder.toString();
		}
		return StringUtils.EMPTY;
	}
	private static final char QUESTION_MARK = '?';
	private static final char COMMA = ',';
}
