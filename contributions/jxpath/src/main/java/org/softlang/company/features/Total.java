package org.softlang.company.features;

import java.util.Iterator;

import org.apache.commons.jxpath.JXPathContext;
import org.softlang.company.model.Company;

public class Total {

	public static double total(Company c) {
		JXPathContext con = JXPathContext.newContext(c);
		Iterator<Double> it = con.iterate("//@salary");
		double result = 0;
		while (it.hasNext()) {
			result += it.next();
		}
		return result;
	}
}
