package org.softlang.company.tests;

import static org.softlang.company.features.Depth.*;
import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class DepthTest {

    @Test
    public void testDepth() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        assertEquals(3, depth(c), 0);
    }

}