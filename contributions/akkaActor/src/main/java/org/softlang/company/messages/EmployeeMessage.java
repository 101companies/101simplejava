package org.softlang.company.messages;

import java.util.List;

import org.softlang.company.model.Employee;

public class EmployeeMessage {
	private List<Employee> employees;

	public EmployeeMessage(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
