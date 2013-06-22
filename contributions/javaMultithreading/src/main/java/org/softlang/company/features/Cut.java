package org.softlang.company.features;

import org.softlang.company.features.context.CompanyContextManager;
import org.softlang.company.features.context.ConcurrentContext;
import org.softlang.company.features.action.CutAction;
import org.softlang.company.model.Company;

public class Cut {

    /**
     * Perform cut, concurrently
     */

    public static void cutWithThreads(Company company) {
        CompanyContextManager.execute(new ConcurrentContext(),
                                      company, new CutAction());
    }

    /**
     * Perform cut, sequentially
     */
    public static void cut(Company company) {
        company.cut();
    }

}