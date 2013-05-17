package org.softlang.company.tests;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import org.softlang.company.features.Parsing;
import org.softlang.company.features.Unparsing;

import org.w3c.dom.Document;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnparsingTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sampleCompany.xml";
    private static String output =
        "build/outputs"
        + File.separator
        + "output.xml";

    @Test
    public void unparseCompany() throws Exception {
        Document doc = Parsing.loadDocument(sampleCompany);
        double totalPre = total(doc);
        cut(doc);
        new File("build/outputs").mkdir();
        Unparsing.saveDocument(doc,output);
        Document cutDoc = Parsing.loadDocument(output);
        double total = total(cutDoc);
        assertEquals(199873.5, total, 0);
    }

}