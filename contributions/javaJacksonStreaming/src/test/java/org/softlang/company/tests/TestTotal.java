package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;
import org.softlang.company.features.Total;

public class TestTotal {

	@Test
	public void testTotal() {
		String in = "inputs" + File.separator + "sampleCompany.json";
		assertEquals(326927.0, Total.total(new File(in)), 0.0);
	}

}
