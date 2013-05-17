package org.softlang.company.features;

import org.softlang.company.model.Employee;
import org.softlang.company.features.template.Walker;

public class Cut extends Walker {
    public void visit(Employee e) {
        e.setSalary(e.getSalary() / 2.0);
    }

}