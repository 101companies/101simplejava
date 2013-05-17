package org.softlang.company.features.visitor;

import org.softlang.company.model.*;

public interface VoidVisitor {

    void visit(Company o);
    void visit(Department o);
    void visit(Employee o);

}