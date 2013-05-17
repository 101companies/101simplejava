package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnparsingTest {

    @Test
    public void testUnparsing() {
        new File("build" + File.separator + "outputs").mkdir();
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        writeCompany(c,"build/outputs" + File.separator + "testCompany.ser");
		readCompany("build/outputs" + File.separator + "testCompany.ser");
    }

}