package org.softlang.company.features;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Total {

	public static double total(JsonObject obj) {
		double result = 0.0;
		if (obj.has("departments")) {
			result += total(obj.getAsJsonArray("departments"));
		}
		if (obj.has("employees")) {
			result += total(obj.getAsJsonArray("employees"));
		}
		if (obj.has("manager")) {
			result += total(obj.getAsJsonObject("manager"));
		}
		if (obj.has("salary")) {
			result += obj.getAsJsonPrimitive("salary").getAsDouble();
		}
		return result;
	}

	private static double total(JsonArray array) {
		double result = 0.0;
		for (JsonElement temp : array)
			if (temp.isJsonObject()) {
				result += total(temp.getAsJsonObject());
			}
		return result;
	}
}
