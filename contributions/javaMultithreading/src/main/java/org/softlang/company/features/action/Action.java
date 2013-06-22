package org.softlang.company.features.action;

import org.softlang.company.features.context.Context;

public interface Action<X, Y> {

    public void execute(Context context, X param);

    public Y getResult();

}