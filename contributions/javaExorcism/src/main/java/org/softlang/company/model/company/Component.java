package org.softlang.company.model.company;

import org.softlang.company.features.visitor.ReturningVisitor;
import org.softlang.company.features.visitor.VoidVisitor;

/**
 * The root class of the object model for companies.
 * All objects in a company have a name.
 * There is also general visitor support.
 */
public interface Component {
	String getName();
	void setName(String name);
	void accept(VoidVisitor v);
	<R> R accept(ReturningVisitor<R> v);
}
