package org.softlang.company.tests;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import org.softlang.company.features.Parsing;

import org.w3c.dom.Document;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sampleCompany.xml";

    @Test
    public void testCut() throws Exception {
        Document doc = Parsing.loadDocument(sampleCompany);
        cut(doc);
        double total = total(doc);
        assertEquals(199873.5, total, 0);
    }

}