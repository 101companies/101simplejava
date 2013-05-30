package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import org.junit.Test;

public class UnparsingTest {

    @Test
    public void testSerialization() {
	    new File("outputs").mkdir();
        Company c = deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
        serializeCompany(c,"outputs" + File.separator + "testCompany.ser");
		deserializeCompany("outputs" + File.separator + "testCompany.ser");
    }

}