package org.softlang.company.tests;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.Unparsing;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class TestUnparsing {

	Company acme;

	@Before
	public void setUp() {
		acme = new Company("ACME Corporation");
		Department d1 = new Department("Research", new Employee("Craig",
				"Redmond", 123456));
		d1.addEmployee(new Employee("Erik", "Utrecht", 12345));
		d1.addEmployee(new Employee("Ralf", "Koblenz", 1234));
		acme.addDepartment(d1);
		Department d2 = new Department("Development", new Employee("Ray",
				"Redmond", 234567));
		Department d3 = new Department("Dev1", new Employee("Klaus", "Boston",
				23456));
		Department d4 = new Department("Dev1.1", new Employee("Karl",
				"Redmond", 2345));
		d4.addEmployee(new Employee("Joe", "Wifi City", 2344));
		d2.addSubDepartment(d3);
		d3.addSubDepartment(d4);
		acme.addDepartment(d2);
	}

	@Test
	public void test() {
		Unparsing.unparse(acme, "test.Company");
	}

}
