package org.softlang.company.features;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Cut {
	/**
	 * Method to search for and cut "salary" properties in a JsonObject 
	 * @param obj JsonObject of the company to cut salaries from
	 */
	public static void cut(JsonObject obj) {

		if (obj.has("departments")) {
			cut(obj.getAsJsonArray("departments"));
		}
		if (obj.has("employees")) {
			cut(obj.getAsJsonArray("employees"));
		}
		if (obj.has("manager")) {
			cut(obj.getAsJsonObject("manager"));
		}
		if (obj.has("salary")) {
			double temp = obj.getAsJsonPrimitive("salary").getAsDouble();
			obj.addProperty("salary", temp / 2);
		}
	}

	
	/**
	 * Helper method for cut
	 * @param arr JsonArray to search and cut salaries for
	 */
	private static void cut(JsonArray arr) {
		for (JsonElement temp : arr)
			if (temp.isJsonObject()) {
				cut(temp.getAsJsonObject());
			}
	}
}
