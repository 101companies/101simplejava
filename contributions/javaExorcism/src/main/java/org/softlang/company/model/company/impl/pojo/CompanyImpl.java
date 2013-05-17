package org.softlang.company.model.company.impl.pojo;

import org.softlang.company.model.company.*;
import org.softlang.company.features.visitor.*;

public class CompanyImpl extends ContainerImpl implements Company {

	/**
	 * Enforce the constraint a company can only aggregate departments
	 */
	public boolean add(Subunit u) {
		if (!(u instanceof Department))
			throw new IllegalArgumentException();
		return super.add(u);
	}
	
	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}	
}
