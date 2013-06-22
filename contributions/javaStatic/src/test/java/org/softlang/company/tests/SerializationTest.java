package org.softlang.company.tests;

import org.softlang.company.model.*;

import static org.softlang.company.features.Serialization.*;

import java.io.File;

import org.junit.Test;

/**
 * We do a round-trip test for serialization.
 * That is, first, we create an object in memory.
 * Then, we write (say, serialize) the object.
 * Then, we read (say, deserialize) the object.
 * Finally, we compare original and read object for structural equality.
 */
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