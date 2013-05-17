package org.softlang.company.features.action;

import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;
import org.softlang.company.features.context.Context;

public class CutAction implements Action<Department, Void> {

    @Override
    public void execute(Context context, Department department) {
        // Lets context organize cutting the sub departments
        for (Department s : department.getSubdepts()) {
            context.execute(this, s);
        }

        // Cut manager and employees
        department.getManager().cut();
        for (Employee e : department.getEmployees()) {
            e.cut();
        }
    }

    @Override
    public Void getResult() {
        return null;
    }

}