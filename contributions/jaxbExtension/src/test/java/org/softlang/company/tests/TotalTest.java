package org.softlang.company.tests;

import static org.softlang.company.features.Serialization.*;
import org.softlang.company.features.Total;
import org.softlang.company.xjc.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TotalTest {

    private static String sampleCompany = "inputs" + File.separator + "sampleCompany.xml";
    private Company c;

    @Before
    public void initCompany() throws JAXBException {
        File sample = new File(sampleCompany);
        c = deserializeCompany(sample);
    }

    @Test
    public void testTotal()
    throws
        JAXBException,
        FileNotFoundException,
        XMLStreamException
    {
        double total = Total.total(c);
        assertEquals(399747, total, 0);
    }

}