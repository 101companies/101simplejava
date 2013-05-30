package org.softlang.company.tests;

import static org.softlang.company.features.sax.SAXUtilities.*;
import org.softlang.company.features.sax.Tracer;

import java.io.File;

import org.junit.Test;

public class TracerTest {

    @Test
    public void testTrace() throws Exception {
        Tracer handler = new Tracer();
        parse(handler, "inputs" + File.separator + "sampleCompany.xml");
    }

}