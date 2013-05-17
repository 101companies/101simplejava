package org.softlang.company.features;

import static org.softlang.company.features.xom.XOMUtilities.*;

import nu.xom.Element;

public class Total {

	public static double total(Element elem) {
		double total = 0;
		for (Element s : descendants(elem, "salary"))
			total += Double.valueOf(s.getValue());
		return total;
	}

}