package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.tests.ParsingTest.sampleCompany;
import org.jdom.Document;
import org.jdom.JDOMException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TotalTest {

    private Document doc;

    @Before
    public void init() throws IOException, JDOMException {
        doc = parseCompany(sampleCompany);
    }

    @Test
    public void testTotal() {
        double total = total(doc);
        assertEquals(399747.0, total, 0.0);
    }

}