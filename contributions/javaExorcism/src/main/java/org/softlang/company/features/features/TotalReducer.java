package org.softlang.company.features.features;

import org.softlang.company.model.company.*;
import org.softlang.company.features.template.Reducer;
import org.softlang.company.features.util.AddDoubles;

/**
 * Salaries are totaled by reducing a company structure
 * such that salaries are extracted from any employee encountered.
 * There is also a walker-based implementation of the same operation.
 */
public class TotalReducer extends Reducer<Double> {

	public TotalReducer() {
		super(AddDoubles.getInstance());
	}
	
	public Double visit(Employee e) {
		return e.getSalary();
	}
}
