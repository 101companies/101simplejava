package org.softlang.company.tests;

import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CutTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testCut() throws IOException {
	    new File("build" + File.separator + "outputs").mkdir();
        Cut cut = new Cut();
        cut.parse(sampleCompany,"build" + File.separator + "output.txt");
        Total total = new Total();
        total.parse("build" + File.separator + "output.txt");
        assertEquals(399747 / 2.0d, total.getTotal(), 0);
    }

}