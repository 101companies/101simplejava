package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import java.io.File;

import org.junit.Test;

public class ParsingTest {

    @Test
    public void testParsing() {
        readCompany("inputs" + File.separator + "sampleCompany.ser");
    }

}