package org.softlang.company.features;

import java.util.Optional;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class Total {

	/**
	 * Method to get the total of all salaries
	 * 
	 * @param company Company to compute total for
	 * @return total of Company company
	 */
	public static double total(Company company) {
		return Optional.ofNullable(company).map(Company::getDepartments)
				.map(departments -> departments.stream().mapToDouble(Total::total).sum()).orElse(0.0);
	}

	/**
	 * Helper Method to get the total of all salaries in a Department
	 * 
	 * @param department Department to compute the total for
	 * @return total of all salaries in Department department
	 */
	private static double total(Department d) {
		double sum = Optional.ofNullable(d.getManager()).map(Employee::getSalary).orElse(0.0);

		sum += Optional.ofNullable(d.getEmployees())
				.map(employees -> employees.stream().mapToDouble(Employee::getSalary).sum()).orElse(0.0);

		return sum + Optional.ofNullable(d.getDepartments())
				.map(departments -> departments.stream().mapToDouble(Total::total).sum()).orElse(0.0);
	}
}
