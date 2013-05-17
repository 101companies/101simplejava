package org.softlang.company.tests;

import org.softlang.company.model.*;
import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class UnparsingTest {

    private static String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";
    private Company c;

    @Before
    public void initCompany() throws JAXBException {
        File sample = new File(sampleCompany);
        c = deserializeCompany(sample);
    }

    @Test
    public void testCut()
    throws
        JAXBException,
        FileNotFoundException,
        XMLStreamException
    {
        new File("build" + File.separator + "outputs").mkdir();
        File out = new File("build" + File.separator + "outputs" + File.separator + "sampleCompany.tmp");
        serializeCompany(out, c);
        c = deserializeCompany(out);
    }

}