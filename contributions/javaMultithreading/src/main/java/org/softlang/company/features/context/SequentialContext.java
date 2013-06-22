package org.softlang.company.features.context;

import org.softlang.company.features.action.Action;

/**
 * Run an action, as is, i.e., sequentially
 */
public class SequentialContext implements Context {

    @Override
    public <X, Y> void execute(Action<X, Y> action, X param) {
        action.execute(this, param);
    }

}