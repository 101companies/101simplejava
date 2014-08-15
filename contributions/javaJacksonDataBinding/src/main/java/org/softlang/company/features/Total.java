package org.softlang.company.features;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class Total {

	/**
	 * Get total of all salaries in company c
	 */
	public static double total(Company c) {
		double result = 0.0;
		if (c.getDepartments() != null)
			for (Department d : c.getDepartments())
				result += total(d);
		return result;
	}

	private static double total(Department d) {
		double result = 0.0;
		if (d.getManager() != null)
			result = d.getManager().getSalary();
		if (d.getEmployees() != null)
			for (Employee e : d.getEmployees())
				result += e.getSalary();
		if (d.getDepartments() != null)
			for (Department d2 : d.getDepartments())
				result += total(d2);
		return result;
	}

}
