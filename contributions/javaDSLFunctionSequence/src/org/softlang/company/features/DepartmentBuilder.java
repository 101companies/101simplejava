package org.softlang.company.features;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;

public class DepartmentBuilder implements UnitBuilder{

	private UnitBuilder parent;
	
	private Department department = new Department();
	private List<EmployeeBuilder> employees = new LinkedList<EmployeeBuilder>();
	private List<DepartmentBuilder> subDepartments = new LinkedList<DepartmentBuilder>();
	
	public DepartmentBuilder(UnitBuilder parent) {
		this.parent = parent;
	}

	public void setName(String name) {
		this.department.setName(name);
	}

	public EmployeeBuilder manager(String name) {
		EmployeeBuilder manager = new EmployeeBuilder(this);
		this.department.setManager(manager.getContent());
		manager.setName(name);
		return manager;
	}

	public EmployeeBuilder employee(String name) {
		EmployeeBuilder child = new EmployeeBuilder(this);
		employees.add(child);
		child.setName(name);
		return child;
	}

	public DepartmentBuilder department(String name) {
		DepartmentBuilder child = new DepartmentBuilder(this);
		subDepartments.add(child);
		child.setName(name);
		return child;
	}

	public UnitBuilder setInactive() {
		return parent;
	}

	public UnitBuilder endDepartment() {
		return parent;
	}

	public Company endCompany() {
		return parent.endCompany();
	}

	public Department getContent() {
		for(DepartmentBuilder builder : subDepartments){
			department.getSubdepts().add(builder.getContent());
		}
		for(EmployeeBuilder builder : employees){
			department.getEmployees().add(builder.getContent());
		}
		return department;
	}

}
