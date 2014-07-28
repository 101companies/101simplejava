package org.softlang.company.features.tokens;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.model.Employee;

public class EmployeesToken {
	private final List<Employee> value = new LinkedList<Employee>();

	public EmployeesToken(Employee... employees) {
		for(Employee employee : employees){
			this.value.add(employee);
		}
	}

	public List<Employee> getValue() {
		return value;
	}

}
