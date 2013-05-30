package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Parsing.*;

import org.w3c.dom.Document;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    private static String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";

    @Test
    public void testCutAllEmployees() throws Exception {
        Document doc = parseDocument(sampleCompany);
        cutAllEmployees(doc);
        double total = total(doc);
        assertEquals(199873.5, total, 0);
    }    

    @Test
    public void testCutManagersOnly() throws Exception {
        Document doc = parseDocument(sampleCompany);
        cutManagersOnly(doc);
        double total = total(doc);
        assertEquals(207835.0, total, 0);
    }

}