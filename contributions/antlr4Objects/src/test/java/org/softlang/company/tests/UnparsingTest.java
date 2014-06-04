package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;
import org.softlang.company.features.*;

import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnparsingTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    private static String output =
        "outputs"
        + File.separator
        + "output.txt";

    @Test
    public void testUnparsing()
            throws IOException, RecognitionException {
        new File("outputs").mkdir();
        Company c = parse(sampleCompany);
        new Cut().cut(c);
        Unparsing p = new Unparsing();
        p.unparseCompany(c,output);
        c = parse(output);
        double total = new Total().total(c);
        assertEquals(399747 / 2.0d, total, 0);
    }

}