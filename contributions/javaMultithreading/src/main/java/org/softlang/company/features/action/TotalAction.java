package org.softlang.company.features.action;

import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;
import org.softlang.company.features.context.Context;

/**
 * Total a department in a context
 */
public class TotalAction implements Action<Department, Double> {

	private double total = 0;

	public void execute(Context context, Department department) {

    	// Delegate execution for all departments to the context
		for (Department sub : department.getSubdepts()) {
			context.execute(this, sub);
		}

        // Total manager and employees, sequentially
		addToTotal(department.getManager().getSalary());
		for (Employee e : department.getEmployees()) {
			addToTotal(e.getSalary());
		}
	}

	// Synchronized access to the aggregation variable
    private synchronized void addToTotal(double x) {
        total += x;
	}	

	/**
	 * Return aggregated total assuming all threads were completed
	 */
	public Double getResult() {
		return total;
	}

}