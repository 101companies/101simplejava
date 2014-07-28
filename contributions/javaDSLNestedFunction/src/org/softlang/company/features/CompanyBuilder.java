package org.softlang.company.features;

import org.softlang.company.features.tokens.AddressToken;
import org.softlang.company.features.tokens.EmployeesToken;
import org.softlang.company.features.tokens.ManagerToken;
import org.softlang.company.features.tokens.NameToken;
import org.softlang.company.features.tokens.SalaryToken;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class CompanyBuilder {
	public static Company company(NameToken name, Department... departments) {
		Company company = new Company();
		company.setName(name.getValue());
		for (Department department : departments) {
			company.getDepts().add(department);
		}
		return company;
	}

	public static Department department(NameToken name, ManagerToken manager, EmployeesToken employees, Department... subDepartments) {
		Department department = new Department();
		department.setName(name.getValue());
		department.setManager(manager.getValue());
		for(Employee employee : employees.getValue()){
			department.getEmployees().add(employee);
		}
		for(Department depts : subDepartments){
			department.getSubdepts().add(depts);
		}
		return department;
	}
	
	public static Employee employee(NameToken name, AddressToken address, SalaryToken salary){
		Employee employee = new Employee();
		employee.setName(name.getValue());
		employee.setAddress(address.getValue());
		employee.setSalary(salary.getValue());
		return employee;
	}
	
	public static AddressToken address(String value){
		return new AddressToken(value);
	}
	
	public static SalaryToken salary(double value){
		return new SalaryToken(value);
	}
	
	public static ManagerToken manager(NameToken name, AddressToken address,
			SalaryToken salary) {
		return new ManagerToken(employee(name, address, salary)) ;
	}
	
	public static ManagerToken manager(Employee employee) {
		return new ManagerToken(employee);
	}
	
	public static NameToken name(String name) {
		return new NameToken(name);
	}
	
	public static EmployeesToken employees(Employee... employees) {
		return new EmployeesToken(employees);
	}
}
