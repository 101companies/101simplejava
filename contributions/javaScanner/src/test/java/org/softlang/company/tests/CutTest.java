package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import org.softlang.company.features.Cut;

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
	    new File("outputs").mkdir();
        Cut cut = new Cut();
        cut.cut(sampleCompany,"outputs" + File.separator + "output.txt");
        double total = total("outputs" + File.separator + "output.txt");
        assertEquals(399747 / 2.0d, total, 0);
    }

}