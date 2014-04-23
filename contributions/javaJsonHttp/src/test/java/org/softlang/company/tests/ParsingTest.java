package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.parseCompany;
import java.io.IOException;
import org.junit.Test;

public class ParsingTest {

	// URI pointing to JSON input in a GitHub repo
    public static String sampleCompany = "https://raw.githubusercontent.com/101companies/101simplejava/master/contributions/javaJson/inputs/sampleCompany.json";

    @Test
    public void testParsing() throws IOException {
        parseCompany(sampleCompany);
    }

}