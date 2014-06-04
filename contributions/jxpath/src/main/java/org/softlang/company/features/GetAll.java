package org.softlang.company.features;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jxpath.JXPathContext;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class GetAll {
	public static List<Employee> getAllEmployees(Company c) {
		JXPathContext con = JXPathContext.newContext(c);
		@SuppressWarnings("unchecked")
		ArrayList<Employee> es = (ArrayList<Employee>) con
				.selectNodes("//employees|//manager");

		return es;
	}

	public static List<Department> getAllDepartments(Company c) {
		JXPathContext con = JXPathContext.newContext(c);
		@SuppressWarnings("unchecked")
		ArrayList<Department> ds = (ArrayList<Department>) con
				.selectNodes("//departments|//subDepartments");

		return ds;
	}
}
