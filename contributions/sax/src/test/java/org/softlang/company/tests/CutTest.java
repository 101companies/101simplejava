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
        // new File("outputs").mkdir();
        Cut handler1 = new Cut("output.xml"); // "outputs" + File.separator + 
        parse(handler1, "inputs" + File.separator + "sampleCompany.xml");
        Total handler2 = new Total();
        parse(handler2, "output.xml"); // "outputs" + File.separator + 
        assertEquals(399747 / 2.0d, handler2.getTotal(), 0);
    }

}