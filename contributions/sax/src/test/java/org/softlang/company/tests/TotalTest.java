package org.softlang.company.tests;

import static org.softlang.company.features.sax.SAXUtilities.*;
import org.softlang.company.features.Total;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class TotalTest {

    @Test
    public void testTotal() throws Exception {
        Total handler = new Total();
        parse(handler, "inputs/sampleCompany.xml");
        assertEquals(399747, handler.getTotal(), 0);
    }

}