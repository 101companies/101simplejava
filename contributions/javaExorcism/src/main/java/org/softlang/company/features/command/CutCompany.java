package org.softlang.company.features.command;

import org.softlang.company.model.company.Company;
import org.softlang.company.model.company.Employee;
import org.softlang.company.features.template.Walker;

/**
 * Construct a salary cut for all salaries in a company
 */
public class CutCompany extends Batch {

	public CutCompany(Company c) {
		new Walker() {
			public void visit(Employee e) {
				add(new CutEmployee(e));
			}
		}.postorder(c);
	}
}
