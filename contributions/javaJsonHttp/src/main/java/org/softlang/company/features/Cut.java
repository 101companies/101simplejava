package org.softlang.company.features;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public class Cut {

	/**
	 * @param obj
	 *            input JSON object
	 * @return output JSON object
	 */
	public static JsonObject cut(JsonObject obj) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		for (String key : obj.keySet())
			cut(builder, key, obj.get(key));
		return builder.build();
	}

	/**
	 * @param arr
	 *            input JSON array
	 * @return output JSON array
	 */
	public static JsonArray cut(JsonArray arr) {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (JsonValue item : arr)
			cut(builder, item);
		return builder.build();
	}

	/**
	 * @param builder
	 *            An object builder to which to add to
	 * @param key
	 *            A key for the input value
	 * @param val
	 *            The input value
	 */
	private static void cut(JsonObjectBuilder builder, String key, JsonValue val) {
		switch (val.getValueType()) {
		case NUMBER:
			Double num = ((JsonNumber) val).doubleValue();
			if (key.equals("salary"))
				// Halve salary
				num /= 2;
			builder.add(key, num);
			break;
		case OBJECT:
			builder.add(key, cut((JsonObject) val));
			break;
		case ARRAY:
			builder.add(key, cut((JsonArray) val));
			break;
		default:
			builder.add(key, val);
			break;
		}
	}

	/**
	 * @param builder
	 *            An array builder to which to add to
	 * @param val
	 *            The input value
	 */
	private static void cut(JsonArrayBuilder builder, JsonValue val) {
		switch (val.getValueType()) {
		case OBJECT:
			builder.add(cut((JsonObject) val));
			break;
		case ARRAY:
			builder.add(cut((JsonArray) val));
			break;
		default:
			builder.add(val);
			break;
		}
	}

}