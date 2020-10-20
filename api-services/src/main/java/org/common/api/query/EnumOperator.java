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
public enum EnumOperator {
	/**
	 * Equals
	 */
	AND(" AND "), 
	/**
	 * Less than
	 */
	OR(" OR ");
	
	private final String value; 
	
	EnumOperator(String val) {
		this.value = val;
	}
	
	private static final Map<String, EnumOperator> namesMap = new HashMap<>(14);
	private static final Map<String, EnumOperator> namesMap2 = new HashMap<>(14);

	
    static {
        namesMap.put(AND.value, AND);
        namesMap.put(OR.value, OR);
		
		// give support for mongo db operators:
		// https://docs.mongodb.com/v3.2/reference/operator/query/
		namesMap2.put("$or", OR);
		namesMap2.put("$and", AND);
    }
	
	@Override
	public String toString() {
		return this.value;
	}
	
	@JsonCreator
    public static EnumOperator forValue(final String value) {
        EnumOperator tmp = namesMap.get(value);
		if( tmp == null) {
			tmp = namesMap2.get(value);
		}
		return tmp;
    }

    @JsonValue
    public String getStringValue() {
        for (Entry<String, EnumOperator> entry : namesMap.entrySet()) {
            if (entry.getValue() == this  )
                return entry.getKey();
        }

        return null; // or fail
    }
	
}
