package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

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
		
		CompanyBuilder builder = new CompanyBuilder();
		Company mcCompany = builder
				.company(NAME_COMP)
				.department(NAME_DEP)
				.endCompany();
		assertEquals(cqCompany, mcCompany);
	}

	@Test
	public void testManager() {
		Company cqCompany = createSampleCompany();
		
		Employee manager = createSampleEmployee();
		cqCompany.getDepts().get(0).setManager(manager);
		
		CompanyBuilder builder = new CompanyBuilder();
		Company mcCompany = builder
				.company(NAME_COMP)
					.department(NAME_DEP)
						.manager(NAME_EMPL)
							.salary(SALARY)
							.address(ADDRESS)
				.endCompany();
		assertEquals(cqCompany, mcCompany);
	}
	
	@Test
	public void testSubDeparment() {
		Company cqCompany = createSampleCompany();
		
		Department subdep = new Department();
		subdep.setName(NAME_SUBDEP);
		cqCompany.getDepts().get(0).getSubdepts().add(subdep);
		
		CompanyBuilder builder = new CompanyBuilder();
		Company mcCompany = builder
				.company(NAME_COMP)
					.department(NAME_DEP)
						.department(NAME_SUBDEP)
				.endCompany();
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
