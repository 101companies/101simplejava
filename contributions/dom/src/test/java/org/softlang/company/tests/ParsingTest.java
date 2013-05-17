package org.softlang.company.tests;

import org.softlang.company.features.Parsing;

import org.w3c.dom.Document;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParsingTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sampleCompany.xml";

    @Test
    public void testCut() throws Exception {
        Parsing.loadDocument(sampleCompany);
    }

}