package org.softlang.company.model.company.impl.pojo;

import org.softlang.company.model.company.*;
import org.softlang.company.features.visitor.*;

public abstract class ComponentImpl implements Component {
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public abstract void accept(VoidVisitor v);
	public abstract <R> R accept(ReturningVisitor<R> v);
}
