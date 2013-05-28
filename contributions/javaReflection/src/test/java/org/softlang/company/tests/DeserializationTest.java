package org.softlang.company.tests;

import static org.softlang.company.features.Serialization.*;
import java.io.File;
import org.junit.Test;

public class DeserializationTest {

    @Test
    public void testDeserialization() {
        readCompany("inputs" + File.separator + "sampleCompany.ser");
    }
}