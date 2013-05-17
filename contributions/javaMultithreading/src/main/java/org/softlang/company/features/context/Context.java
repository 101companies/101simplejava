package org.softlang.company.features.context;

import org.softlang.company.features.action.Action;

public interface Context {
	<X, Y> void execute(Action<X, Y> action, X param);
}