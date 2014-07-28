package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.CompanyBuilder.name;
import static org.softlang.company.features.CompanyBuilder.department;
import static org.softlang.company.features.CompanyBuilder.employees;
import static org.softlang.company.features.CompanyBuilder.manager;

import org.junit.Test;
import org.softlang.company.features.CompanyBuilder;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class DepartmentBuilderTest {

	private static final String NAME_SUBDEP = "subdep";
	private static final String NAME_COMP = "abc2";
	private static final String NAME_DEP = "aggs2";
	
	private static final String NAME_EMPL = "Hugo";
	private static final Double SALARY = 1.43;
	private static final String ADDRESS = "Berlin";
	
	@Test
	public void testDepartment() {
		Company cqCompany = createSampleCompany();
		
		Company mcCompany = CompanyBuilder
				.company(
					name(NAME_COMP), 
					department(
						name(NAME_DEP), 
						manager(null), 
						employees()
					)
					
				);
		assertEquals(cqCompany, mcCompany);
	}

	
	@Test
	public void testManager() {
		Company cqCompany = createSampleCompany();
		
		Employee manager = createSampleEmployee();
		cqCompany.getDepts().get(0).setManager(manager);
		
		Company mcCompany = CompanyBuilder
				.company(
					name(NAME_COMP), 
					department(
						name(NAME_DEP), 
						manager(this.createSampleEmployee()), 
						employees()
					)
					
				);
		assertEquals(cqCompany, mcCompany);
	}
	
	@Test
	public void testSubDeparment() {
		Company cqCompany = createSampleCompany();
		
		Department subdep = new Department();
		subdep.setName(NAME_SUBDEP);
		cqCompany.getDepts().get(0).getSubdepts().add(subdep);
		
		Company mcCompany = CompanyBuilder
				.company(
					name(NAME_COMP), 
					department(
						name(NAME_DEP), 
						manager(null), 
						employees(),
						department(
							name(NAME_SUBDEP), 
							manager(null), 
							employees()
						)
					)
					
				);
		assertEquals(cqCompany, mcCompany);
	}
	
	@Test
	public void testEmployees() {
		Company cqCompany = createSampleCompany();
		cqCompany.getDepts().get(0).getEmployees().add(createSampleEmployee());
		
		Company mcCompany = CompanyBuilder
				.company(
					name(NAME_COMP), 
					department(
						name(NAME_DEP), 
						manager(null), 
						employees(createSampleEmployee())
					)
					
				);
		assertEquals(cqCompany, mcCompany);
	}
	
	private Company createSampleCompany() {
		Company cqCompany = new Company();
		cqCompany.setName(NAME_COMP);
		Department dep = new Department();
		dep.setName(NAME_DEP);
		cqCompany.getDepts().add(dep);
		return cqCompany;
	}
	
	private Employee createSampleEmployee() {
		Employee empl = new Employee();
		empl.setName(NAME_EMPL);
		empl.setAddress(ADDRESS);
		empl.setSalary(SALARY);
		return empl;
	}
	
}
