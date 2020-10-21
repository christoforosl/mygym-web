package org.common.api.query;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 *
 * @author christoforosl
 */
//@JsonSerialize(using = EnumConditionSerializer.class)
//@JsonDeserialize(using=EnumConditionDeserializer.class)
public enum EnumCondition {
	/**
	 * Equals
	 */
	EQUALS("="), 
	/**
	 * Less than
	 */
	LT("<"),
	/**
	 * Less than or equal
	 */
	LTE("<="), 
	/**
	 * Greater than
	 */
	GT(">"),
	/**
	 * Greater than or equal
	 */
	GTE(">="), 
	/**
	 * The classic sql like, will result in searhing of string as in %[value]%
	 */
	LIKE("LIKE"), 
	
	/**
	 * Before like, will result in searhing of string as in %[value]
	 */
	BLIKE("BLIKE"), 
	
	/**
	 * After like, will result in searhing of string as in [value]%
	 */
	ALIKE("ALIKE"), 
	
	/**
	 * Not equals
	 */
	NOT_EQUALS("<>"),
	
	/**
	 * In clause
	 */
	IN("IN()"), 
	
	/**
	 * Not in
	 */
	NOT_IN("NOT IN()");
	
	private final String value; 
	
	EnumCondition(String val) {
		this.value = val;
	}
	
	private static final Map<String, EnumCondition> namesMap = new HashMap<>(14);
	private static final Map<String, EnumCondition> namesMap2 = new HashMap<>(14);

	
    static {
        namesMap.put(EQUALS.value, EQUALS);
        namesMap.put(LT.value, LT);
        namesMap.put(LTE.value, LTE);
		namesMap.put(GT.value, GT);
        namesMap.put(GTE.value, GTE);
		namesMap.put(LIKE.value, LIKE);
		namesMap.put(BLIKE.value, BLIKE);
		namesMap.put(ALIKE.value, ALIKE);
		namesMap.put(NOT_EQUALS.value, NOT_EQUALS);
		
		// give support for mongo db operators:
		// https://docs.mongodb.com/v3.2/reference/operator/query/
		namesMap2.put("$eq", EQUALS);
		namesMap2.put("$gt", GT);
		namesMap2.put("$gte", GTE);
		namesMap2.put("$lt", LT);
		namesMap2.put("$lte", LTE);
		namesMap2.put("$ne", NOT_EQUALS);
		namesMap2.put("$in", IN);
		namesMap2.put("$nin", NOT_IN);
		namesMap2.put("$lk", LIKE);
		namesMap2.put("$blk", BLIKE);
		namesMap2.put("$alk", ALIKE);
    }
	
	@Override
	public String toString() {
		return this.value;
	}
	
	@JsonCreator
    public static EnumCondition forValue(final String value) {
        EnumCondition tmp = namesMap.get(value);
		if( tmp == null) {
			tmp = namesMap2.get(value);
		}
		return tmp;
    }

    @JsonValue
    public String getStringValue() {
        for (Entry<String, EnumCondition> entry : namesMap.entrySet()) {
            if (entry.getValue() == this  )
                return entry.getKey();
        }

        return null; // or fail
    }
	
}
