package org.softlang.company.model.company.factory;

import org.softlang.company.model.company.Company;
import org.softlang.company.model.company.Department;
import org.softlang.company.model.company.Employee;

/**
 * The factory interface for constructing all possible company objects
 */
public interface Factory {
	Company mkCompany();
	Department mkDepartment();
	Employee mkEmployee();
}
