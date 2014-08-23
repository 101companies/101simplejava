package org.softlang.company.features;

import org.softlang.company.model.Company;

public interface UnitBuilder {

	DepartmentBuilder department(String name);

	public UnitBuilder endDepartment();

	Company endCompany();
}
