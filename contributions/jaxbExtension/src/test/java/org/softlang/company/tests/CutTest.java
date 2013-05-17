package org.softlang.company.tests;

import org.softlang.company.model.*;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;
import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Unparsing.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class CutTest {

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
        Cut.cut(c);
        File tmp = new File("sampleCompany.tmp");
        serializeCompany(tmp, c);
        c = deserializeCompany(tmp);
        Double total = Total.total(c);
        assertEquals(399747 / 2.0d, total, 0);
        tmp.delete();
    }

}