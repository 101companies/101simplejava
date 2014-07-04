package org.softlang.company.messages;

import java.util.ArrayList;
import java.util.List;

import org.softlang.company.model.Department;

public class DepartmentsMessage {
	private List<Department> departments = new ArrayList<Department>();

	public DepartmentsMessage(List<Department> departments) {
		this.departments = departments;

	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
}
