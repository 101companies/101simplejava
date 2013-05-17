package org.softlang.company.tests;

import org.softlang.company.model.*;
import static org.softlang.company.features.Parsing.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ParsingTest {

    private static String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";
    private Company c;

    @Test
    public void parseCompany() throws JAXBException {
        File sample = new File(sampleCompany);
        c = deserializeCompany(sample);
    }

}