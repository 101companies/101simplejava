package org.softlang.company.features.features;

import org.softlang.company.model.company.*;
import org.softlang.company.features.template.Walker;

public class SimpleCut extends Walker {
	public void visit(Employee e) {
		e.setSalary(e.getSalary() / 2.0);
	}
}
