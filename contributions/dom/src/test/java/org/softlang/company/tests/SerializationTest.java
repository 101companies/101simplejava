package org.softlang.company.tests;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import org.softlang.company.features.Serialization;

import org.w3c.dom.Document;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class SerializationTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sampleCompany.xml";
    private static String output =
        "outputs"
        + File.separator
        + "output.xml";

    @Test
    public void testDeserialization() throws Exception {
        Serialization.loadDocument(sampleCompany);
    }

    @Test
    public void testSerialization() throws Exception {
        Document doc = Serialization.loadDocument(sampleCompany);
        double totalPre = total(doc);
        cut(doc);
        new File("outputs").mkdir();
        Serialization.saveDocument(doc,output);
        Document cutDoc = Serialization.loadDocument(output);
        double total = total(cutDoc);
        assertEquals(totalPre / 2.0, total, 0);
    }

}