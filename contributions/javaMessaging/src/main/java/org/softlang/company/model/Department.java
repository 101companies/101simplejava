package org.softlang.company.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private Employee manager;
	private List<Department> departments = new ArrayList<Department>();
	private List<Employee> employees = new ArrayList<Employee>();

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

	public Department() {
		// TODO Auto-generated constructor stub
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

	public void cut() {
		if (manager != null)
			manager.cut();
		for (Employee e : employees)
			e.cut();
		for (Department d : departments)
			d.cut();
	}

	public double total() {
		double result = 0.0;
		if (manager != null)
			result += manager.getSalary();
		for (Employee e : employees)
			result += e.getSalary();
		for (Department d : departments)
			result += d.total();
		return result;
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
