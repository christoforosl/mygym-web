package org.common.api.query;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *
 * @author chris
 */
public class QuerySort implements Comparable<QuerySort> {

	@Override
	public int compareTo(QuerySort o) {
		if(this.sequence > o.sequence)return 1;
		if(this.sequence < o.sequence)return -1;
		return 0;
	}

	/**
	 * 1- ascending; -1 - descending This is so that it conforms with mongodb conventions
	 */
	public enum sortOrder {
		ASCENDING(1),
		DESCENDING(-1);

		private final Integer value;
		private static final Map<Integer, sortOrder> intToTypeMap = new HashMap<>();

		static {
			for (sortOrder type : sortOrder.values()) {
				intToTypeMap.put(type.value, type);
			}
		}

		sortOrder(Integer i) {
			value = i;
		}

		public int intValue() {
			return value;
		}

		public static sortOrder fromInt(final Integer i) {
			if (i == null) {
				return null;
			}
			sortOrder type = intToTypeMap.get(i);
			return type;
		}

		@JsonCreator
		public static sortOrder fromString(final String s) {
			if (s == null) {
				return null;
			}
			Collection<sortOrder> vals = intToTypeMap.values();
			for (sortOrder ev : vals) {
				if (ev.toString().equals(s)) {
					return ev;
				}
			}
			return null;
		}

	}
	
	private int sequence = 0;
	private String fieldName;
	private sortOrder order;

	public QuerySort(final int insequence, final String fieldName, final sortOrder order)  {
		this.fieldName = fieldName;
		this.order = order;
		this.sequence = insequence;
	}

	
	public String getFieldname() {
		return fieldName;
	}

	public void setFieldname(final String fieldname) {
		this.fieldName = fieldname;
	}

	public sortOrder getOrder() {
		return order;
	}

	public void setOrder(final sortOrder order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "QuerySort{" + "sequence=" + sequence + ", fieldName=" + fieldName + ", order=" + order + '}';
	}
	
}
