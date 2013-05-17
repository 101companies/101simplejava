package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class ParsingTest {

    @Test
    public void testParsing() {
        readCompany("inputs" + File.separator + "sampleCompany.ser");
    }

}