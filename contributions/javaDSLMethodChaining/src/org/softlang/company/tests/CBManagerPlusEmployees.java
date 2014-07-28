package org.softlang.company.tests;

import org.softlang.company.features.CompanyBuilder;

public class CBManagerPlusEmployees extends CompanyBuilder {

	@Override
	protected void build() {
		company("abc2");
			department("dep1");
				manager("Hugo");
					address("Berlin");
					salary(1.43);
				employee("Paul");
					address("Rostock");
					salary(1.444);
				employee("Lara");
					address("Koblenz");
					salary(653.42);
	}

}
