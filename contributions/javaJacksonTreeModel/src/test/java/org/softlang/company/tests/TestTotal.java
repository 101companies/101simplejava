package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.softlang.company.features.Parsing;
import org.softlang.company.features.Total;

import com.fasterxml.jackson.databind.JsonNode;

public class TestTotal {

	@Test
	public void testTotal() {
		String in = "inputs" + File.separator + "sampleCompany.json";
		JsonNode c = Parsing.parseFromFile(new File(in));
		assertEquals(326927.0, Total.total(c), 0.0);
	}

}
