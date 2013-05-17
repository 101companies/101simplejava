package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test acceptor for companies
 */
public class ParsingTest {

    /**
     * Positive test case
     */
    @Test
    public void testPositiveAcceptance() throws FileNotFoundException, IOException {
        assertTrue(acceptCompany("inputs" + File.separator + "sample.Company"));
    }

    /**
     * Negative test case
     */
    @Test
    public void testNegativeAcceptance() throws FileNotFoundException, IOException {
        assertFalse(acceptCompany("inputs" + File.separator + "nonSample.Company"));
    }

    /**
     * Positive test case
     */
    @Test
    public void testPositiveParsing() throws FileNotFoundException, IOException {
        assertTrue(parseCompany("inputs" + File.separator + "sample.Company"));
    }

    /**
     * Negative test case
     */
    @Test
    public void testNegativeParsing() throws FileNotFoundException, IOException {
        assertFalse(parseCompany("inputs" + File.separator + "nonSample.Company"));
    }

}