package org.softlang.company.tests;

import static org.softlang.company.features.Serialization.*;

import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SerializationTest {

    public Element docRoot;

    @Test
    public void testDeserialization() throws ValidityException, ParsingException, IOException {
        deserializeCompany("inputs" + File.separator + "sampleCompany.xml");
    }

}