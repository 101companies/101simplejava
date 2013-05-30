package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import javax.xml.bind.JAXBException;

import java.io.File;

import org.junit.Test;

public class ParsingTest {

    private static String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";

    @Test
    public void parseCompany() throws JAXBException {
        File sample = new File(sampleCompany);
        deserializeCompany(sample);
    }

}