package org.softlang.company.features;

import java.util.Optional;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class Cut {

	/**
	 * Method to cut salaries in half
	 * 
	 * @param company Company to cut salaries from
	 */
	public static void cut(Company company) {
		Optional.ofNullable(company).map(Company::getDepartments)
				.ifPresent(departments -> departments.forEach(Cut::cut));
	}

	/**
	 * Helper method for cut
	 * 
	 * @param department Department to cut salaries from
	 */
	private static void cut(Department department) {
		Optional.ofNullable(department.getManager()).ifPresent(Cut::cut);

		Optional.ofNullable(department.getEmployees()).ifPresent(employees -> employees.forEach(Cut::cut));

		Optional.ofNullable(department.getDepartments()).ifPresent(departments -> departments.forEach(Cut::cut));
	}

	/**
	 * Helper method for cut
	 * 
	 * @param employee Employee to cut salary from
	 */
	private static void cut(Employee employee) {
		employee.setSalary(employee.getSalary() / 2);
	}
}
