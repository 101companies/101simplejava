package org.softlang.company.tests;

import org.softlang.company.features.CompanyBuilder;

public class CBSubDepartments extends CompanyBuilder {

	@Override
	protected void build() {
		company("abc2");
			department("dep1");
			department("dep2");
	}

}
