package org.softlang.company.tests;

import static org.softlang.company.features.Serialization.*;
import org.softlang.company.model.Company;

import java.io.File;

import org.junit.Test;

public class SerializationTest {

    @Test
    public void testDeserialization() {
        deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
    }

    @Test
    public void testSerialization() {
        new File("outputs").mkdir();
        Company c = deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
        serializeCompany(c,"outputs" + File.separator + "testCompany.ser");
		deserializeCompany("outputs" + File.separator + "testCompany.ser");
    }

}