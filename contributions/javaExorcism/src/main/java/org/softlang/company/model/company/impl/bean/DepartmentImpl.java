package org.softlang.company.model.company.impl.bean;

import org.softlang.company.model.company.*;
import org.softlang.company.features.visitor.*;

public class DepartmentImpl extends ContainerImpl implements Department {
	
	public Employee getManager() {
		for (Subunit u : subunits())
			if (u instanceof Employee) {
				Employee e = (Employee)u;
				if (e.getManager())
					return e;
			}
		return null;
	}	

	public void accept(VoidVisitor v) {
		v.visit(this);
	}

	public <R> R accept(ReturningVisitor<R> v) {
		return v.visit(this);
	}
}
