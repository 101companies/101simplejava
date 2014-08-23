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
    public void testSubDepartments() {
		String name = "abc2";
		
		Company cqCompany = new Company();
		cqCompany.setName(name);
		Department dep1 = new Department();
		dep1.setName("dep1");
		cqCompany.getDepts().add(dep1);
		Department dep2 = new Department();
		dep2.setName("dep2");
		dep1.getSubdepts().add(dep2);
		
		CompanyBuilder builder = new CBSubDepartments();
		builder.run();
		Company fcCompany = builder.getValue();
		
		assertEquals(cqCompany, fcCompany);
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
