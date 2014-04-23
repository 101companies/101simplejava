package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.tests.ParsingTest.sampleCompany;
import javax.json.JsonObject;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TotalTest {

    private JsonObject jsonObject;
 
    @Before
    public void init() throws IOException {
    	jsonObject = parseCompany(sampleCompany);
    }

    @Test
    public void testTotal() {
        double total = total(jsonObject);
        assertEquals(326927.0, total, 0.0);
    }

}