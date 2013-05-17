package org.softlang.company.tests;

import static org.softlang.company.features.sax.SAXUtilities.*;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    @Test
    public void testCut() throws Exception {
	    new File("build" + File.separator + "outputs").mkdir();
        Cut handler1 = new Cut("output.xml");
        parse(handler1, "inputs/sampleCompany.xml");
        Total handler2 = new Total();
        parse(handler2, "output.xml");
        assertEquals(399747 / 2.0d, handler2.getTotal(), 0);
    }

}