package org.softlang.company.features;

import org.softlang.company.features.visitor.*;
import org.softlang.company.model.*;

public class Cut implements VoidVisitor {

    public void visit(Company o) {
        for (Department d : o.getDepts())
            d.accept(this);
    }

    public void visit(Department o) {
        o.getManager().accept(this);
        for (Subunit s : o.getSubunits())
            s.accept(this);
    }

    public void visit(Employee o) {
        o.setSalary(o.getSalary() / 2.0d);
    }

}