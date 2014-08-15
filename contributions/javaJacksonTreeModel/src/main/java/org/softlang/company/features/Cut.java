package org.softlang.company.features;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Cut {
	/**
	 * Divide all double-properties of the JsonNode node with the name "salary"
	 * by 2
	 * 
	 * @param node
	 */
	public static void cut(JsonNode node) {

		if (node.has("departments")) {
			Iterator<JsonNode> iterator = node.get("departments").elements();
			while (iterator.hasNext()) {
				cut(iterator.next());
			}
		}
		if (node.has("employees")) {
			Iterator<JsonNode> iterator = node.get("employees").elements();
			while (iterator.hasNext()) {
				cutEmployee((ObjectNode) iterator.next());
			}
		}
		if (node.has("manager")) {
			cutEmployee((ObjectNode) node.get("manager"));
		}

	}

	private static void cutEmployee(ObjectNode e) {
		DoubleNode salary = new DoubleNode(e.get("salary").asDouble() / 2);
		e.set("salary", salary);
	}
}
