package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.Unparsing;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class TestUnparsing {

	Company acme;
	String example = "";

	@Before
	public void setUp() {
		example = "";
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
		Department d4 = new Department("Dev1.1", new Employee("Karl", "Riga",
				2345));
		d4.addEmployee(new Employee("Joe", "Wifi City", 2344));
		d2.addSubDepartment(d3);
		d3.addSubDepartment(d4);
		acme.addDepartment(d2);
		try {
			BufferedReader read = new BufferedReader(new FileReader("inputs"
					+ File.separatorChar + "sample.Company"));
			while (read.ready())
				example += read.readLine();
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		new File("outputs").mkdir();
		Unparsing
				.unparse(acme, "outputs" + File.separatorChar + "test.Company");
		String out = "";
		try {
			BufferedReader read = new BufferedReader(new FileReader("outputs"
					+ File.separatorChar + "test.Company"));
			while (read.ready())
				out += read.readLine();
			read.close();
		} catch (IOException e) {
			fail();
		}
		assertEquals(0, out.compareTo(example));
	}

}
