package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnparsingTest {

    @Test
    public void testSerialization() {
	    new File("build" + File.separator + "outputs").mkdir();
        Company c = deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
        serializeCompany(c, "build" + File.separator + "outputs" + File.separator + "testCompany.ser");
		Company d = deserializeCompany("build" + File.separator + "outputs" + File.separator + "testCompany.ser");
    }

}