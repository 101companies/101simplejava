package org.softlang.company.features;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class Cut {

	/**
	 * Cut salaries of company c in half
	 * 
	 */
	public static void cut(Company c) {
		if (c.getDepartments() != null)
			for (Department d : c.getDepartments())
				cut(d);
	}

	private static void cut(Department d) {
		if (d.getManager() != null)
			d.getManager().setSalary(d.getManager().getSalary() / 2);
		if (d.getEmployees() != null)
			for (Employee e : d.getEmployees())
				e.setSalary(e.getSalary() / 2);
		if (d.getDepartments() != null)
			for (Department d2 : d.getDepartments())
				cut(d2);
	}
}
