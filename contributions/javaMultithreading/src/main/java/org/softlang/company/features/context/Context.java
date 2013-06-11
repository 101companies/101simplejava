package org.softlang.company.features.context;

import org.softlang.company.features.action.Action;

/**
 * Run an action in a context
 */
public interface Context {
	<X, Y> void execute(Action<X, Y> action, X param);
}