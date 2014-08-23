package org.softlang.company.tests;

import org.softlang.company.features.CompanyBuilder;
import org.softlang.company.model.Company;

public class CBBigExample extends CompanyBuilder{

	@Override
	protected void build() {
	company("ACME Corporation");
		department("Research");
			manager("Craig");
				address("Redmond");
				salary(123456);
			employee("Erik");
				address("Utrecht");
				salary(12345);
			employee("Ralf");
				address("Koblenz");
				salary(1234);
		endDepartment();
		department("Development");
			manager("Ray");
				address("Redmond");
				salary(234567);
				
			department("Dev1");
				manager("Klaus");
					address("Boston");
					salary(23456);
					
				department("Dev1.1");
					manager("Karl");
						address("Riga");
						salary(2345);
					employee("Joe");
						address("Wifi City");
						salary(2344);
				endDepartment();
			endDepartment();
		endDepartment();
	}

}
