package org.softlang.company.tests;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Parsing.*;

import nu.xom.Builder;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CutTest {

    public Element docRoot;

    @Before
    public void init() throws ValidityException, ParsingException, IOException {
        docRoot = parseCompany("inputs/sampleCompany.xml");
    }

    @Test
    public void testCut() {
        double preCutSalary = total(docRoot);
        cut(docRoot);
        double newSalary = total(docRoot);
        assertEquals(preCutSalary / 2, newSalary, 0.0);
    }

}