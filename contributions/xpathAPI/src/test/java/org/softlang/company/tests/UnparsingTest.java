package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;

import org.w3c.dom.Document;

import java.io.File;

import org.junit.Test;

public class UnparsingTest {

    private static String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";
	private static String testCompany = "outputs" + File.separator + "testCompany.xml";
	
	@Test
    public void testUnparsing() throws Exception {
        new File("outputs").mkdir();
        Document c = parseDocument(sampleCompany);
        unparseDocument(c, testCompany);
        parseDocument(testCompany);
    }

}