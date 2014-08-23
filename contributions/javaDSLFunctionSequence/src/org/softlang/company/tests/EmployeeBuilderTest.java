package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.features.CompanyBuilder;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class EmployeeBuilderTest {

	private final String NAME_COMP = "abc2";
	private final String NAME_DEP = "dep1";
	
	private final String NAME_EMPL = "Hugo";
	private final Double SALARY = 1.43;
	private final String ADDRESS = "Berlin";
	
	private final String NAME_EMPL2 = "Paul";
	private final Double SALARY2 = 1.444;
	private final String ADDRESS2 = "Rostock";
	
	private final String NAME_EMPL3 = "Lara";
	private final Double SALARY3 = 653.42;
	private final String ADDRESS3 = "Koblenz";
	
	@Test
	public void testSingleEmployee() {
		
		Company cqCompany = new Company();
		cqCompany.setName(NAME_COMP);
		
		Department dep = createSampleDepartment();
		dep.getEmployees().add(createSampleEmployee());
		cqCompany.getDepts().add(dep);
		
		CompanyBuilder builder = new CBSingleEmployee();
		builder.run();
		Company fcCompany = builder.getValue();
		
		assertEquals(cqCompany, fcCompany);
	}

	@Test
	public void testManager() {
		
		Company cqCompany = new Company();
		cqCompany.setName(NAME_COMP);
		
		Department dep = createSampleDepartment();
		dep.setManager(createSampleEmployee());
		cqCompany.getDepts().add(dep);
		
		CompanyBuilder builder = new CBManager();
		builder.run();
		Company fcCompany = builder.getValue();
		
		assertEquals(cqCompany, fcCompany);
	}
	
	@Test
	public void testManagerPlusEmployees() {
		
		Company cqCompany = new Company();
		cqCompany.setName(NAME_COMP);
		
		Department dep = createSampleDepartment();
		dep.setManager(createSampleEmployee());
		dep.getEmployees().add(createSampleEmployee2());
		dep.getEmployees().add(createSampleEmployee3());
		cqCompany.getDepts().add(dep);
		
		CompanyBuilder builder = new CBManagerPlusEmployees();
		builder.run();
		Company fcCompany = builder.getValue();
		
		assertEquals(cqCompany, fcCompany);
	}
	
	private Department createSampleDepartment() {
		Department dep = new Department();
		dep.setName(NAME_DEP);
		return dep;
	}

	private Employee createSampleEmployee() {
		Employee empl = new Employee();
		empl.setName(NAME_EMPL);
		empl.setAddress(ADDRESS);
		empl.setSalary(SALARY);
		return empl;
	}
	
	private Employee createSampleEmployee2() {
		Employee empl = new Employee();
		empl.setName(NAME_EMPL2);
		empl.setAddress(ADDRESS2);
		empl.setSalary(SALARY2);
		return empl;
	}
	
	private Employee createSampleEmployee3() {
		Employee empl = new Employee();
		empl.setName(NAME_EMPL3);
		empl.setAddress(ADDRESS3);
		empl.setSalary(SALARY3);
		return empl;
	}
}
