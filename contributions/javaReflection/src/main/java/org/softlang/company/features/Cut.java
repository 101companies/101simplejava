package org.softlang.company.features;

import org.softlang.company.model.*;

public class Cut {

    public static void cut(Company c) {
    		Walker w = new Walker(c);
    		for (Object o : w)
    			if (o instanceof Employee) {
    				Employee e = (Employee)o;
    				e.setSalary(e.getSalary() / 2);
    			}
    }
}