package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ParsingTest {

    public Element docRoot;

    @Test
    public void testParsing() throws ValidityException, ParsingException, IOException {
        parseCompany("inputs" + File.separator + "sampleCompany.xml");
    }

}