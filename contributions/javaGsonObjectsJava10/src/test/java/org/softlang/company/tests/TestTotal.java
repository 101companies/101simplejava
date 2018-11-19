package org.softlang.company.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.softlang.company.features.Parsing;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class TestTotal {

	@Test
	public void testTotal() {
		Company company;
		try {
			company = Parsing.parseFromFile("inputs" + File.separator + "sampleCompany.json");
		} catch (IOException e) {
			fail();
			return;
		}
		assertEquals(326927.0, Total.total(company));
	}

	@Test
	public void testTotalEmptyCompany() {
		Company emptyCompany = new Company("Empty");
		assertEquals(0, Total.total(emptyCompany));
	}

	@Test
	public void testCutNull() {
		assertEquals(0, Total.total(null));
	}

	@Test
	public void testCutWithNullDepartments() {
		Company nullDepartCompany = new Company("Empty", null);
		assertEquals(0, Total.total(nullDepartCompany));
	}

	@Test
	public void testCutWithNullManager() {
		Company company = new Company("Test");
		company.addDepartment(new Department("Testing", null));
		assertEquals(0, Total.total(company));
	}

	@Test
	public void testCutWithNullSubdepartments() {
		Company company = new Company("Test");
		Department department = new Department("Testing", new Employee("Test Manager", "testing street", 2), null);
		company.addDepartment(department);
		assertEquals(2, Total.total(company));
	}
}
