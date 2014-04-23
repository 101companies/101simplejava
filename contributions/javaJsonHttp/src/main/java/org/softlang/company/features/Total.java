package org.softlang.company.features;

import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Total {

	/**
	 * @param obj
	 *            JSON object to traverse
	 * @return salary total
	 */
	public static double total(JsonObject obj) {
		return total(null, obj);
	}

	/**
	 * @param key1
	 *            key for the value at hand
	 * @param val1
	 *            JSON value to traverse
	 * @return salary total
	 */
	private static double total(String key1, JsonValue val1) {

		double sum = 0;

		switch (val1.getValueType()) {

		case NUMBER:
			if (key1 != null && key1.equals("salary")) {
				// Aggregate salaries
				Double salary = ((JsonNumber) val1).doubleValue();
				sum += salary;
			}
			// Otherwise skip numbers
			break;

		case ARRAY:
			// Iterate over array items
			for (JsonValue item : (JsonArray) val1)
				sum += total(key1, item);
			break;

		case OBJECT:
			// Iterate over inner JSON objects
			JsonObject obj = (JsonObject) val1;
			for (String key2 : obj.keySet()) {
				JsonValue val2 = obj.get(key2);
				sum += total(key2, val2);
			}
			break;

		default:
			// Skip all other values
			break;
		}

		return sum;
	}

}