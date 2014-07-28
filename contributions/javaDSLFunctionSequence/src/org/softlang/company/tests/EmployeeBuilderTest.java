package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.features.CompanyBuilder;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class EmployeeBuilderTest {

	private final String NAME_COMP = "abc2";
	private final String NAME_DEP = "aggs2";
	
	private final String NAME_EMPL = "Hugo";
	private final Double SALARY = 1.43;
	private final String ADDRESS = "Berlin";
	
	@Test
	public void testSingleEmployee() {
		
		Company cqCompany = new Company();
		cqCompany.setName(NAME_COMP);
		
		Department dep = createSampleDepartment();
		dep.getEmployees().add(createSampleEmployee());
		cqCompany.getDepts().add(dep);
		
		CompanyBuilder builder = new CompanyBuilder();
		Company mcCompany = builder
				.company(NAME_COMP)
					.department(NAME_DEP)
						.employee(NAME_EMPL)
							.salary(SALARY)
							.address(ADDRESS)
				.endCompany();
		assertEquals(cqCompany, mcCompany);
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
	
}
