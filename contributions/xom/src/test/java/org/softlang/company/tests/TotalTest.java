package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Serialization.*;

import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TotalTest {

    public Element docRoot;

    @Before
    public void init() throws ValidityException, ParsingException, IOException {
        docRoot = deserializeCompany("inputs" + File.separator + "sampleCompany.xml");
    }

    @Test
    public void testTotal() {
        double total = total(docRoot);
        assertEquals(399747.0, total, 0.0);
    }

}