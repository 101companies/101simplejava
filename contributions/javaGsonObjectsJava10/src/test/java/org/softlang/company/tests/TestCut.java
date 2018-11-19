package org.softlang.company.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Parsing;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class TestCut {

	@Test
	public void testCut() {
		Company company;
		try {
			company = Parsing.parseFromFile("inputs" + File.separator + "sampleCompany.json");
		} catch (IOException e) {
			fail();
			return;
		}
		double total = Total.total(company);
		Cut.cut(company);
		assertEquals(total / 2, Total.total(company));
	}

	@Test
	public void testCutEmptyCompany() {
		Company emptyCompany = new Company("Empty");
		Cut.cut(emptyCompany);
		assertEquals(0, Total.total(emptyCompany));
	}

	@Test
	public void testCutNull() {
		Cut.cut(null);
	}

	@Test
	public void testCutWithNullDepartments() {
		Company nullDepartCompany = new Company("Empty", null);
		Cut.cut(nullDepartCompany);
	}

	@Test
	public void testCutWithNullManager() {
		Company company = new Company("Test");
		company.addDepartment(new Department("Testing", null));
		Cut.cut(company);
	}

	@Test
	public void testCutWithNullSubdepartments() {
		Company company = new Company("Test");
		Department department = new Department("Testing", new Employee("Test Manager", "testing street", 2), null);
		company.addDepartment(department);
		Cut.cut(company);
		assertEquals(1, Total.total(company));
	}
}
