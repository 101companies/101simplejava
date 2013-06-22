package org.softlang.company.features.action;

import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;
import org.softlang.company.features.context.Context;

/**
 * Cut a department in a context
 */
public class CutAction implements Action<Department, Void> {

    public void execute(Context context, Department department) {
        // Delegate execution for all departments to the context
        for (Department s : department.getSubdepts()) {
            context.execute(this, s);
        }

        // Cut manager and employees, sequentially
        department.getManager().cut();
        for (Employee emp : department.getEmployees()) {
            emp.cut();
        }
    }

    /**
     * No actual result for salary cut
     */
    public Void getResult() {
        return null;
    }

}