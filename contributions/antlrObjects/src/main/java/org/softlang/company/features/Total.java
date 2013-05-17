package org.softlang.company.features;

import org.softlang.company.model.*;

/*
 * Implementation of the Feature Total
 */

public class Total {

    public double total(Company c) {
        double total = 0;
        for (Department d : c.getDepts())
            total += total(d);
        return total;
    }

    public double total(Department d) {
        double total = 0;
        total += d.getManager().getSalary();
        for (Department sub : d.getSubdepts())
            total += total(sub);
        for (Employee e : d.getEmployees())
            total += total(e);
        return total;
    }

    public double total(Employee e) {
        return e.getSalary();
    }

}