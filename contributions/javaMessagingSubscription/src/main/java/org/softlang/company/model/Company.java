package org.softlang.company.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private List<Department> departments = new ArrayList<Department>();

	public Company(String name) {
		super();
		this.name = name;

	}

	public Company(String name, List<Department> departments) {
		super();
		this.name = name;
		this.departments = departments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void addDepartment(Department d) {
		this.departments.add(d);
	}

	public void cut() {
		for (Department d : departments)
			d.cut();
	}

	public double total() {
		double result = 0.0;
		for (Department d : departments)
			result += d.total();
		return result;
	}

	@Override
	public String toString() {
		String result = "Company " + this.name + ":\nDepartments: ";
		for (Department d : this.departments)
			result += "\n" + d.getName();
		return result;
	}

}
