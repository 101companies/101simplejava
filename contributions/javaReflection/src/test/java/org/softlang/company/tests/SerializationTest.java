package org.softlang.company.tests;

import static org.softlang.company.features.Serialization.*;
import org.softlang.company.model.Company;
import java.io.File;
import org.junit.Test;

public class SerializationTest {

    @Test
    public void testSerialization() {
        new File("outputs").mkdir();
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        writeCompany(c,"outputs" + File.separator + "testCompany.ser");
		readCompany("outputs" + File.separator + "testCompany.ser");
    }
}