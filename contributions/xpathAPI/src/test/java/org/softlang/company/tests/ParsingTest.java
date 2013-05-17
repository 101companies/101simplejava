package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import org.w3c.dom.Document;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParsingTest {

    private static String sampleCompany = "inputs/sampleCompany.xml";

    @Test
    public void testParsing() throws Exception {
        parseDocument(sampleCompany);
    }

}