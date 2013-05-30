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

}