package org.softlang.company.model.company.factory;

import org.softlang.company.model.company.*;
import org.softlang.company.model.company.impl.pojo.*;

/**
 * A factory that constructs POJPs
 */
public class PojoFactory implements Factory {
	public Company mkCompany() { return new CompanyImpl(); }
	public Department mkDepartment() { return new DepartmentImpl(); }
	public Employee mkEmployee() { return new EmployeeImpl(); }
}
