
package org.softlang.company.features;

import java.util.Optional;

import org.softlang.company.xjc.*;

public class Total {

	public static double total(Company company) {
		
		return company.getDepartment()
				      .stream()
				      .map(depts -> total(depts))
				      .reduce(0.0, Double::sum);
	}

	public static double total(Department department) {
		
		double total = Optional.ofNullable(department.getManager()).map(Employee::getSalary).orElse(0.0);
		
		total += department.getDepartment()
						   .stream()
						   .map(dep -> total(dep))
						   .reduce(0.0, Double::sum);
		
		return total += department.getEmployee()
								  .stream()
								  .map(emp -> emp.getSalary())
								  .reduce(0.0, Double::sum);
	}
}