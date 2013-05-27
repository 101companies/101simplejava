package org.softlang.company.features;

import org.softlang.company.model.*;

public class Total {

    public static Double total(Company c) {
		Walker w = new Walker(c);
		double result = 0;
		for (Object o : w)
			if (o instanceof Employee) {
				Employee e = (Employee)o;
				result += e.getSalary();
			}
		return result;
    }
}