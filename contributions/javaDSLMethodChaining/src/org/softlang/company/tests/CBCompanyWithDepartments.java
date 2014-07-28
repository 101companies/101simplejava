package org.softlang.company.tests;

import org.softlang.company.features.CompanyBuilder;

public class CBCompanyWithDepartments extends CompanyBuilder {

	@Override
	protected void build() {
		company("abc2");
			department("dep1");
			endDepartment();
			department("dep2");
			endDepartment();
	}

}
