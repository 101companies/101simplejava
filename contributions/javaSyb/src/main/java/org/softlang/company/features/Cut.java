package org.softlang.company.features;

import org.softlang.company.model.*;

import static javaf.syb.Transformation.*;
import javaf.prelude.*;

public class Cut {

    public static void cut(Company c) {
        everywhere(orIdentity(updateSalary())).apply(c);
    }

    public static Action<Employee> updateSalary() {
        return new Action<Employee>() {
            public void apply(Employee x) {
                x.setSalary(x.getSalary() / 2);
            }
        };
    }

    public static void cutManagers(Company c) {
        traverse(null).apply(c);
    }    

    public static Action<Object> traverse(final Object parent) {
        return new Action<Object>() {
            public void apply(Object o) {
                orIdentity(updateSalary(parent)).apply(o);
                all(traverse(o)).apply(o);
            }
        };
    }

    public static Action<Employee> updateSalary(final Object parent) {
        return new Action<Employee>() {
            public void apply(Employee x) {
                if (parent instanceof Department)
                    x.setSalary(x.getSalary() / 2);
            }
        };
    }

}