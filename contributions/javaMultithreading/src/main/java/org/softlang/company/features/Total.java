package org.softlang.company.features;

import org.softlang.company.features.context.CompanyContextManager;
import org.softlang.company.features.context.ConcurrentContext;
import org.softlang.company.features.action.TotalAction;
import org.softlang.company.model.Company;

public class Total {

    public static Double totalWithThreads(Company company) {
        return CompanyContextManager.execute(new ConcurrentContext(),
		                                     company, new TotalAction());
    }

    public static Double total(Company company) {
        return company.total();
    }

}