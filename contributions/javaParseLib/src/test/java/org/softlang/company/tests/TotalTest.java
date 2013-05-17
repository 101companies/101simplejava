package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Test Total
 */
public class TotalTest {

    @Test
    public void testTotal() throws FileNotFoundException, IOException {
        assertEquals(total("inputs" + File.separator + "sample.Company"), 399747.0, 0);
    }

}