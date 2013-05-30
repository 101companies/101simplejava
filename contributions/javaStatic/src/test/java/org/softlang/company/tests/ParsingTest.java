package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import java.io.File;

import org.junit.Test;

public class ParsingTest {

    @Test
    public void testDeserialization() {
        deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
    }

}