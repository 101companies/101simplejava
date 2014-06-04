package org.softlang.company.features;

import org.softlang.company.model.*;

/*
 * Implementation of the Feature Cut
 */

public class Cut {

    public void cut(Company c) {
        for (Department d : c.getDepts())
            cut(d);
    }

    public void cut(Department d) {
        cut(d.getManager());
        for (Department sub : d.getSubdepts())
            cut(sub);
        for (Employee e : d.getEmployees())
            cut(e);
    }

    public void cut(Employee e) {
        e.setSalary(e.getSalary() / 2);
    }

}