/**
 * 
 */
package org.softlang.company.junit;

import static org.junit.Assert.assertEquals;

import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.ConditionedCut;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

/**
 * @author Matthias Paul
 * 
 */
public class TestConditionedCut {

	Company snpp = new Company("Springfield Nuclear Power Plant");

	/**
	 * Build Simpsons Example Company
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Department management = new Department("Burn's Office", new Employee(
				"Montgomery Burns", "Springfield", 1000000));
		management.addEmployee(new Employee("Waylon Smithers", "Springfield",
				55555));
		Department sector7g = new Department("Sector 7-G", new Employee(
				"Charlie", "Shelbyville", 8494));
		Department sector4f = new Department("Sector 4-F", new Employee("Joe",
				"Shelbyville", 7489));
		Department sector7m = new Department("Sector 7-M", new Employee(
				"Eugene Fisk", "Springfield", 10486));
		Department sector7q = new Department("Sector 7-Q", new Employee(
				"Frank Grimes", "Shelbyville", 12487));
		sector7g.addEmployee(new Employee("Carl Carlson", "Springfield", 3234));
		sector7g.addEmployee(new Employee("Lenny Leonard", "Springfield", 2599));
		sector7g.addEmployee(new Employee("Homer Simpson", "Evergreen Terrace",
				1875));
		sector4f.addEmployee(new Employee("Al Simmons", "Detroit", 861));
		sector4f.addEmployee(new Employee("Dr. Olberman", "Shelbyville", 17538));
		sector7m.addEmployee(new Employee("Stewart", "New York", 5475));
		sector7q.addEmployee(new Employee("Robert Marlow", "New York", 746));
		snpp.addDepartment(management);
		management.addSubDepartment(sector4f);
		management.addSubDepartment(sector7g);
		sector7g.addSubDepartment(sector7m);
		sector7g.addSubDepartment(sector7q);
	}

	/**
	 * Test method for
	 * {@link org.softlang.company.features.ConditionedCut#conditionedCut(org.softlang.company.model.Company, java.lang.String)}
	 * .Expect JXPathInvalidSyntaxException for invalid Condition
	 */
	@Test(expected = JXPathInvalidSyntaxException.class)
	public void testConditionedNoCondition() {
		double totalOld = Total.total(snpp);
		ConditionedCut.conditionedCut(snpp, "");

	}

	/**
	 * Test method for
	 * {@link org.softlang.company.features.ConditionedCut#conditionedCut(org.softlang.company.model.Company, java.lang.String)}
	 * . Test condition for attribute salary
	 */
	@Test
	public void testConditionedCutSalary() {
		ConditionedCut.conditionedCut(snpp, "salary > 10000");
		double effectedSalaries = 1000000 + 55555 + 10486 + 12487 + 17538;
		double notEffectedSalaries = 8494 + 7489 + 3234 + 2599 + 1875 + 861
				+ 5475 + 746;
		assertEquals(notEffectedSalaries + effectedSalaries / 2,
				Total.total(snpp), 0.0);
	}

	/**
	 * Test method for
	 * {@link org.softlang.company.features.ConditionedCut#conditionedCut(org.softlang.company.model.Company, java.lang.String)}
	 * . Test condition for attribute name
	 */
	@Test
	public void testConditionedCutName() {
		ConditionedCut.conditionedCut(snpp, "name != 'Montgomery Burns'");
		double effectedSalaries = 8494 + 7489 + 3234 + 2599 + 1875 + 861 + 5475
				+ 746 + 55555 + 10486 + 12487 + 17538;
		double notEffectedSalaries = 1000000;
		assertEquals(notEffectedSalaries + effectedSalaries / 2,
				Total.total(snpp), 0.0);
	}

	/**
	 * Test method for
	 * {@link org.softlang.company.features.ConditionedCut#conditionedCut(org.softlang.company.model.Company, java.lang.String)}
	 * . Test condition for attribute address
	 */
	@Test
	public void testConditionedCutAddress() {
		ConditionedCut.conditionedCut(snpp, "address = 'New York'");
		double effectedSalaries = 746 + 5475;
		double notEffectedSalaries = 1000000 + 8494 + 7489 + 3234 + 2599 + 1875
				+ 861 + 55555 + 10486 + 12487 + 17538;
		assertEquals(notEffectedSalaries + effectedSalaries / 2,
				Total.total(snpp), 0.0);
	}

	/**
	 * Test method for
	 * {@link org.softlang.company.features.ConditionedCut#conditionedCut(org.softlang.company.model.Company, java.lang.String)}
	 * . Test condition for attribute name, address and salary
	 */
	@Test
	public void testConditionedCutAll() {
		ConditionedCut
				.conditionedCut(snpp,
						"address = 'Springfield' and name != 'Carl Carlson' or salary <= 6000");
		double effectedSalaries = 1000000 + 55555 + 10486 + 2599 + 1875 + 861
				+ 5475 + 746 + 3234;
		double notEffectedSalaries = 8494 + 7489 + 12487 + 17538;
		assertEquals(notEffectedSalaries + effectedSalaries / 2,
				Total.total(snpp), 0.0);
	}

}
