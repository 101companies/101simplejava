package org.softlang.company.features;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;

public class Total {
	/**
	 * Add all double-properties of the JsonNode node with the name "salary"
	 * 
	 * @param node
	 * 
	 */
	public static double total(JsonNode node) {
		double result = 0.0;
		if (node != null) {
			if (node.get("salary") != null)
				return node.get("salary").asDouble();
			else {
				if (node.has("departments")) {
					Iterator<JsonNode> iterator = node.path("departments")
							.elements();
					while (iterator.hasNext()) {
						result += total(iterator.next());

					}
				}
				if (node.has("employees")) {
					Iterator<JsonNode> iterator = node.path("employees")
							.elements();
					while (iterator.hasNext()) {
						result += total(iterator.next());
					}
				}
			}

			if (node.get("manager") != null) {
				result += total(node.get("manager"));
			}
		}
		return result;
	}

}