package org.common.api.query;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.common.api.query.sqlbuilders.CriterionSQLBuilder;
import org.common.api.query.sqlbuilders.ICriterionSQLBuilder;
import org.common.api.query.sqlbuilders.PainTextCriterionSQLBuilder;
import org.common.api.query.sqlbuilders.SubqueryCriterionSQLbuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;




/**
 * Class that builds criteria to sent to the BaseResource.query from the 
 * criteria sent from the client ( angular ) site
 * @author pavlosp
 */
public class CriteriaBuilder {
	
	protected static final Logger LOGGER = Logger.getLogger(CriteriaBuilder.class.getName());
		
	private QueryCriteria criteria;
	
	private final QueryStatement statement = new QueryStatement();

	
	public QueryStatement getStatement() {
		return statement;
	}

	public void setCriteria(final QueryCriteria criteria) {
		this.criteria = criteria;
	}
	
	/**
	 * 
	 * @param criteria
	 * @return 
	 */
	public final QueryStatement buildCriteria(QueryCriteria criteria) {
		this.setCriteria(criteria);
		this.buildWhereClause();
		return this.getStatement();
	}
	

	/**
	 * creates the core where clause for the current ModelObject fields.
	 * For nested queries we must create 'ModelObjectName'CriteriaHandler.java class
	 */
	protected void buildWhereClause() {

		this.getStatement().reset();
		final StringBuilder sort = new StringBuilder();
		
		if (criteria != null && criteria.getFilters()!= null && criteria.getFilters().size()>0) {
			statement.getSqlStatementBuffer().append("and (");
			final List<Criterion> fm = criteria.getFilters();
			
			for (final Criterion  criterion : fm) {
				
				ICriterionSQLBuilder critSQLBuilder;
				
				// if this is a subquery, load SubqueryCriterionSQLbuilder and pass it the 
				// key in the properties file
				if (criterion.getType()==EnumCriterionType.nested) {
					critSQLBuilder = new SubqueryCriterionSQLbuilder();
					final String criterionName = criterion.getCriterionName();
					((SubqueryCriterionSQLbuilder)critSQLBuilder).setSubquerySQLKey(criterionName);
				
				} else {
					critSQLBuilder = this.getCriterionSQLBuilder(criterion);
				}
				
				critSQLBuilder.buildSQLCondition(statement, criterion);
				 
			}
		 	statement.getSqlStatementBuffer().append(")");
		}
		//order by
		if (criteria != null && criteria.getSortFields() != null) {
			ArrayList<String> sortField = new ArrayList<>();
			for (QuerySort sField : criteria.getSortFields()) {
				final String sortOrder = sField.getOrder()==QuerySort.sortOrder.ASCENDING ? " asc " : " desc ";
				sortField.add( sField.getFieldname() + sortOrder);
				
			}
			if (!sortField.isEmpty()) {
				sort.append(" ORDER BY ").append(StringUtils.join(sortField, COMMA));
			}
		}

		this.getStatement().appendToSQL(sort);
	}
	
	@JsonIgnore
	private final CriterionSQLBuilder criterionSQLBuilder = new CriterionSQLBuilder();

	@JsonIgnore
	public ICriterionSQLBuilder getCriterionSQLBuilder(final Criterion criterion) {
		Validate.notNull(criterion,"Criterion argument is null");
		
		if(criterion.getType()==EnumCriterionType.nested){
			return CustomCriteria.current().getCustomCriterionBuilder(criterion.getCriterionName());
		}else if (criterion.getType()==EnumCriterionType.plainText) {
			return new PainTextCriterionSQLBuilder();
		} else {
			return criterionSQLBuilder;
		}
	}

	
	private static final String COMMA = ",";
	
}
