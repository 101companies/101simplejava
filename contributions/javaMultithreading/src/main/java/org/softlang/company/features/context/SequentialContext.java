package org.softlang.company.features.context;

import org.softlang.company.features.action.Action;

public class SequentialContext implements Context {

	@Override
	public <X, Y> void execute(Action<X, Y> action, X param) {
		action.execute(this, param);
	}

}