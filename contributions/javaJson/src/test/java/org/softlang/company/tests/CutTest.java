package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.features.Cut.cut;
import static org.softlang.company.tests.ParsingTest.sampleCompany;
import javax.json.JsonObject;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CutTest {

    private JsonObject jsonObject;
    
    @Before
    public void init() throws IOException {
    	jsonObject = parseCompany(sampleCompany);
    }

	@Test
	public void testCut() {
        double total1 = total(jsonObject);
        double total2 = total(cut(jsonObject));
		assertEquals(total1/2, total2, 0.0);
	}

}