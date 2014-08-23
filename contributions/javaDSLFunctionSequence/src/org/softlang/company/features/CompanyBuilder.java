package org.softlang.company.features;

import java.util.Stack;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public abstract class CompanyBuilder {

	private Company company = new Company();
	
	private Stack<Department> currentDepartmentStack = new Stack<Department>();
	private Employee currentEmployee;
	
	public Company run() {
		build();
		return getValue();
	}
	
	public Company getValue() {
		return company;
	}

	abstract protected void build();
	
	protected void company(String name) {
		this.company.setName(name);
	}

	protected void department(String name) {
		Department newDepartment = new Department();
		newDepartment.setName(name);
		
		if(currentDepartmentStack.isEmpty()){
			company.getDepts().add(newDepartment);
		}else{
			currentDepartmentStack.peek().getSubdepts().add(newDepartment);
		}
		
		currentDepartmentStack.push(newDepartment);
	}

	protected void salary(double salary) {
		currentEmployee.setSalary(salary);
	}

	protected void address(String address) {
		currentEmployee.setAddress(address);
	}

	protected void employee(String name) {
		createEmployee(name);
		currentDepartmentStack.peek().getEmployees().add(currentEmployee);
	}

	protected void manager(String name) {
		createEmployee(name);
		currentDepartmentStack.peek().setManager(currentEmployee);
	}

	private void createEmployee(String name) {
		currentEmployee = new Employee();
		currentEmployee.setName(name);
	}

	protected void endDepartment() {
		currentDepartmentStack.pop();
	}
}
