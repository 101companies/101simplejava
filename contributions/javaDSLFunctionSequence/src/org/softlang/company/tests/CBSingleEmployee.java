package org.softlang.company.tests;

import org.softlang.company.features.CompanyBuilder;

public class CBSingleEmployee extends CompanyBuilder {

	@Override
	protected void build() {
		company("abc2");
			department("dep1");
				employee("Hugo");
					address("Berlin");
					salary(1.43);
	}

}
