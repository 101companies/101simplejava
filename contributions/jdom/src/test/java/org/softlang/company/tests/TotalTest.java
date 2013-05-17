package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.features.*;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TotalTest {

    public Document doc;
    String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";

    @Before
    public void init() throws IOException, JDOMException {
        doc = parseCompany(sampleCompany);
    }

    @Test
    public void testTotal() {
        double total = Total.total(doc);
        assertEquals(399747.0, total, 0.0);
    }

}