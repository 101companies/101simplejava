package org.softlang.company.features;

import org.softlang.company.model.*;
import org.softlang.company.features.template.Reducer;

public class Total extends Reducer<Double> {

    @Override
    public Double zero() {
        return 0.0;
    }

    @Override
    public Double append(Double x, Double y) {
        return x+y;
    }

    @Override
    public Double visit(Employee e) {
        return e.getSalary();
    }

}