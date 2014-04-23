package org.softlang.company.features;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.filter.ElementFilter;
import java.util.Iterator;

public class Total {

    public static double total(Document doc) {

        // Aggregate salaries
        double total = 0;

        // Iterate over all salary elements
        Iterator<?> iterator = doc.getDescendants(new ElementFilter("salary"));
        while (iterator.hasNext()) {
            Element elem = (Element)iterator.next();
            Double salary = Double.valueOf(elem.getText());
            total += salary;
        }

        return total;
    }

}