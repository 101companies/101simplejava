package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;

import org.w3c.dom.Document;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnparsingTest {

    private static String sampleCompany = "inputs/sampleCompany.xml";
	private static String testCompany = "build/outputs/testCompany.xml";
	
	@Test
    public void testUnparsing() throws Exception {
        new File("build" + File.separator + "outputs").mkdir();
        Document c = parseDocument(sampleCompany);
        unparseDocument(c, testCompany);
        parseDocument(testCompany);
    }

}