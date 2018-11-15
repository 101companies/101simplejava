package org.softlang.company.tests;

import java.io.IOException;
import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.tests.ParsingTest.sampleCompany;

public class TotalTest
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
    * Normal test for determining the total salary of a JSON object and expecting that it is equal to a given value.
    */

   @Test
   public void testTotalNormalCase()
   {
      double total = total(sampleCompanyObject);
      assertEquals(326927.0, total, 0.0);
   }

   /**
    *
    *
    *
    */

   @Test
   public void testTotalBorderCase()
   {
      double total = 0.0;
   }
}