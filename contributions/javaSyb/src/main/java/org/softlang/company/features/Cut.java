package org.softlang.company.features;

import static org.softlang.company.features.javaf.syb.Transformation.*;
import org.softlang.company.model.*;
import org.softlang.company.features.javaf.prelude.*;

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