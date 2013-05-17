package org.softlang.company.model.company.impl.bean;

import org.softlang.company.model.company.*;
import org.softlang.company.features.visitor.*;

public class CompanyImpl extends ContainerImpl implements Company {

	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}	
}
