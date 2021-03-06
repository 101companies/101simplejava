package org.softlang.company.features.action;

import org.softlang.company.features.context.Context;

/**
 * Perform an action in a context while possibly producing a result eventually
 */
public interface Action<X, Y> {

    public void execute(Context context, X param);

    public Y getResult();

}