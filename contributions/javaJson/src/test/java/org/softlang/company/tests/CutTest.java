package org.softlang.company.tests;

import java.io.IOException;
import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.Cut.cut;
import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.tests.ParsingTest.sampleCompany;

public class CutTest
{
   private JsonObject sampleCompanyObject;

   /**
    * Initialization of JSON object for tests
    *
    * @throws IOException
    */

   @Before
   public void init() throws IOException
   {
      sampleCompanyObject = parseCompany(sampleCompany);
   }

   /**
    * Normal test for reading a sample company JSON, determining the total salary of it twice while the second value got cut before.
    * It's expected that total2 should be the half of total1 after executing the cut method.
    */

   @Test
   public void testCutNormalCase()
   {
      double total1 = total(sampleCompanyObject);
      double total2 = total(cut(sampleCompanyObject));
      assertEquals(total1 / 2, total2, 0.0);
   }

   /**
    *
    *
    *
    */

   @Test
   public void testCutBorderCase()
   {
      double total = 0.0;
   }
}