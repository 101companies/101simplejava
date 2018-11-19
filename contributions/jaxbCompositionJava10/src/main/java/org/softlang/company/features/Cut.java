
package org.softlang.company.features;

import java.util.Optional;

import org.softlang.company.xjc.*;

public class Cut {

	public static void cut(Company company) {
		Optional.ofNullable(company)
				.map(Company::getDepartment)
				.ifPresent(depts -> depts.forEach(Cut::cut));
	}

	public static void cut(Department department) {
		Optional.ofNullable(department.getManager())
				.ifPresent(Cut::cut);
		Optional.ofNullable(department.getDepartment())
				.ifPresent(dep -> dep.forEach(Cut::cut));
		Optional.ofNullable(department.getEmployee())
				.ifPresent(employee -> employee.forEach(Cut::cut));
	}

	public static void cut(Employee employee) {
		employee.setSalary(employee.getSalary() / 2);
	}

}