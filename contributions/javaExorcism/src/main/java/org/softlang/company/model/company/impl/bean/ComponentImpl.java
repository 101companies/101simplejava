package org.softlang.company.model.company.impl.bean;

import org.softlang.company.model.company.*;
import org.softlang.company.features.visitor.*;
import java.util.Observable;

/**
 * Observability and a parent axis are added on top of the Component interface.
 */
public abstract class ComponentImpl extends Observable implements Component {
	private ComponentImpl parent;
	private String name;
	public String getName() {
		return name; 
	}
	public void setName(String name) { 
		this.name = name; 
		setChanged();
		notifyObservers("name");		
	}
	public ComponentImpl getParent() { return parent; }
	/* package */ void setParent(ComponentImpl parent) { this.parent = parent; }
	public abstract void accept(VoidVisitor v);
	public abstract <R> R accept(ReturningVisitor<R> v);
}
