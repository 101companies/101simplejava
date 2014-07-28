package org.softlang.company.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CompanyBuilderTest.class, DepartmentBuilderTest.class,
		EmployeeBuilderTest.class })
public class AllTests {

}
