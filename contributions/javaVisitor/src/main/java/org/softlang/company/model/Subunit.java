package org.softlang.company.model;

import org.softlang.company.features.visitor.*;

/**
 * A subunit is either an employee unit or a department unit
 * 
 */
public abstract class Subunit {

    /**
     * Accept a void visitor
     */
    public abstract void accept(VoidVisitor v);

    /**
     * Accept a returning visitor
     */
    public abstract <R> R accept(ReturningVisitor<R> v);

}