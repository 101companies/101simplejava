package org.softlang.company.features.context;

import org.softlang.company.features.action.Action;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;

/**
 * Perform a department-level action on a company in a sequential or concurrent context 
 */
public abstract class CompanyContextManager {

	public static <X, Y> Y execute(Context context, Company company,
			Action<Department, Y> action) {

		// Perform the action for each department in the given context
		for (Department department : company.getDepts()) {
			action.execute(context, department);
		}

		// Wait for threads to complete
		if (context instanceof ConcurrentContext) {
			((ConcurrentContext) context).waitForTermination();
		}

		// Retrieve result maintained by the action
		return action.getResult();
	}

}