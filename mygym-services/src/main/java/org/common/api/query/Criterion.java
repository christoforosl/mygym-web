package org.common.api.query;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 *
 * @author christoforosl
 */
public class Criterion {

	public static final String IS_NULL = "isNull";
	public static final String IS_NOT_NULL = "isNotNull";
	
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss'.000Z'";
	private static final DateFormat DF_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);

	private String criterionName;
	private String fieldName;
	private String databaseFieldName;
	private String defaultValue;
	private int index; // criterion index , ie the order where this criterion appears
	
	private EnumCriterionType type;
	private EnumCondition condition = EnumCondition.EQUALS;
	private EnumOperator operator = null;
	
	private String value;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Returns the value parsed from the string value to the datatype of the criterion For example:
	 * <ul>
	 * <li>if criterion is integer data type, this returns a Long object.
	 * <li>if criterion is date, this returns a java.lang.Date object
	 * <li>if criterion is decimal, this returns a java.lang.Double object
	 * <li>else this returns a string
	 * </ul>
	 *
	 * @return
	 */
	public Object getDataTypeValue() {
		
		final String critValue = this.getValue();
		
		if( IS_NOT_NULL.equals(critValue) ||IS_NULL.equals(critValue)) {
			return critValue;
		}
					
		if (this.getType() == EnumCriterionType.date) {
			Date d = null;
			try {
				return DF_DATE_FORMAT.parse(critValue);
			} catch (ParseException ex) {
				// if we could not parse from string format, try a long
				try {
					Calendar c = Calendar.getInstance();
					c.setTimeInMillis( Long.valueOf(critValue) *1000 ); // because the values are coming from javascript
					if(c.get(Calendar.YEAR) > 3000) {
						c.setTimeInMillis( Long.valueOf(critValue) ) ;
					}
					d = c.getTime();
					
				} catch (Exception e) {
					throw new RuntimeException("Could not parse date from Date format or Long.", e);
				}
			}
			if(d!=null && this.getCondition()==EnumCondition.LTE) {
				Calendar c = Calendar.getInstance();
				c.setTime(d);
				c.set(Calendar.HOUR_OF_DAY, 23);
				c.set(Calendar.MINUTE, 59);
				c.set(Calendar.SECOND, 59);
				d = c.getTime();
			}
			
			return  d == null ? null :  new Timestamp( d.getTime() );
			
		} else if (this.getType() == EnumCriterionType.integer) {
			return Long.parseLong(critValue);

		} else if (this.getType() == EnumCriterionType.decimal) {
			return Double.parseDouble(critValue);

		} else {
			return critValue;
		}
	}

	public EnumOperator getOperator() {
		return operator;
	}

	public void setOperator(EnumOperator operator) {
		this.operator = operator;
	}

	/**
	 * returns the value as passed from json as string
	 *
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * sets the value as passed from json as string
	 *
	 * @param value
	 * @return 
	 */
	public Criterion setValue(String value) {
		this.value = value;
		return this;
	}
	
	/**
	 * Returns the criterion name, which by default is the fieldName
	 * @return a unique name identifier
	 */
	public String getCriterionName() {
		final String ret = StringUtils.defaultString(this.criterionName,  
							StringUtils.defaultString(this.fieldName, this.databaseFieldName));
		Validate.notEmpty( ret, "Cant get a criterio name from criterionName,fieldName and databaseFieldName");
		return ret;
	}

	public Criterion setCriterionName(String criterionName) {
		this.criterionName = criterionName;
		return this;
	}

	/**
	 * The client site field name
	 *
	 * @return The client site field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * The JSON field name
	 * @param fieldName
	 * @return 
	 */
	public Criterion setFieldName(final String fieldName) {
		Validate.notEmpty(fieldName, "fieldname cannot be empty/null");
		this.fieldName = fieldName;
		return this;
	}

	public String getDatabaseFieldName() {
		return databaseFieldName;
	}

	/**
	 * The database field name is automatically set upon setting of the fieldName
	 * @param databaseFieldName
	 * @return 
	 */
	public Criterion setDatabaseFieldName(final String databaseFieldName) {
		this.databaseFieldName = databaseFieldName;
		return this;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public Criterion setDefaultValue(final String defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public EnumCriterionType getType() {
		return type;
	}

	public Criterion setType(final EnumCriterionType type) {
		this.type = type;
		return this;
	}

	public EnumCondition getCondition() {
		return condition;
	}

	public Criterion setCondition(final EnumCondition condition) {
		this.condition = condition;
		return this;
	}

	public boolean isLikeClause() {
		return this.getCondition() == EnumCondition.LIKE || 
					this.getCondition() == EnumCondition.ALIKE || 
					this.getCondition() == EnumCondition.BLIKE;
	}

}
