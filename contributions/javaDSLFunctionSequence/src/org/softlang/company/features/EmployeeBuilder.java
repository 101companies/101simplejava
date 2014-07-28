package org.softlang.company.features;

import org.softlang.company.model.Company;
import org.softlang.company.model.Employee;

public class EmployeeBuilder implements UnitBuilder{

	private DepartmentBuilder parent;
	
	private Employee employee = new Employee();
	
	public EmployeeBuilder(DepartmentBuilder parent) {
		this.parent = parent;
	}

	public EmployeeBuilder address(String address) {
		this.employee.setAddress(address);
		return this;
	}

	public DepartmentBuilder department(String name) {
		return parent.department(name);
	}

	public EmployeeBuilder employee(String name) {
		return parent.employee(name);
	}

	public Company endCompany() {
		return parent.endCompany();
	}

	public UnitBuilder endDepartment() {
		return parent.setInactive();
	}

	public Employee getContent() {
		return employee;
	}

	public EmployeeBuilder salary(double salary) {
		this.employee.setSalary(salary);
		return this;
	}

	public EmployeeBuilder salary(int salary) {
		return this.salary((double) salary);
	}

	public void setName(String name) {
		this.employee.setName(name);
	}

}
