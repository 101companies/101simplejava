package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import org.junit.Test;

public class UnparsingTest {

    @Test
    public void testUnparsing() {
        new File("outputs").mkdir();
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        writeCompany(c,"outputs" + File.separator + "testCompany.ser");
		readCompany("outputs" + File.separator + "testCompany.ser");
    }

}