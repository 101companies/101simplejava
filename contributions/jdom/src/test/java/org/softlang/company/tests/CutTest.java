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

public class CutTest {

    public Document doc;
    String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";

    @Before
    public void init() throws IOException, JDOMException {
        doc = parseCompany(sampleCompany);
    }

    @Test
    public void testCut() {
        double preCutSalary = Total.total(doc);
        Cut.cut(doc);
        double newSalary = Total.total(doc);
        assertEquals(preCutSalary/2, newSalary, 0.0);
    }

}