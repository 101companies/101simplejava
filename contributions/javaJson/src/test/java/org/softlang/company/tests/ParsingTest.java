package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.parseCompany;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class ParsingTest {

    public static String sampleCompany = "inputs" + File.separator + "sampleCompany.json";

    @Test
    public void testParsing() throws IOException {
        parseCompany(sampleCompany);
    }

}