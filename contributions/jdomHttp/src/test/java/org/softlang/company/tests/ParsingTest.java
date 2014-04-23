package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.parseCompany;
import java.io.IOException;
import org.jdom.JDOMException;
import org.junit.Test;

public class ParsingTest {

    public static String sampleCompany = "https://raw.githubusercontent.com/101companies/101simplejava/master/contributions/jdom/inputs/sampleCompany.xml";

    @Test
    public void testParsing() throws IOException, JDOMException {
        parseCompany(sampleCompany);
    }

}