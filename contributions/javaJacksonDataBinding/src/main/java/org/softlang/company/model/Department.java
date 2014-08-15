package org.softlang.company.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private Employee manager;
	private List<Department> departments = new ArrayList<Department>();
	private List<Employee> employees = new ArrayList<Employee>();

	public Department() {
		super();
	}

	public Department(String name, Employee manager) {
		super();
		this.name = name;
		this.manager = manager;
	}

	public Department(String name, Employee manager,
			List<Department> subDepartments) {
		super();
		this.name = name;
		this.manager = manager;
		this.departments = subDepartments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee e) {
		this.employees.add(e);
	}

	public void addSubDepartment(Department d) {
		this.departments.add(d);
	}

	@Override
	public String toString() {
		String result = "Department " + this.name + ": \nManager: "
				+ this.manager.getName() + "\nEmployees:";
		for (Employee e : this.employees)
			result += "\n" + e.getName();
		return result;
	}
}
