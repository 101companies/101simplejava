package org.softlang.company.tests;

import java.io.IOException;
import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.tests.ParsingTest.companyWithNegSalary;
import static org.softlang.company.tests.ParsingTest.companyWithZeroSalary;
import static org.softlang.company.tests.ParsingTest.sampleCompany;

public class TotalTest
{

   private JsonObject sampleCompanyObj;
   private JsonObject companyWithZeroSalaryObj;
   private JsonObject companyWithNegSalaryObj;

   /**
    * Initialization of JSON object for tests
    *
    * @throws IOException
    */

   @Before
   public void init() throws IOException
   {
      sampleCompanyObj = parseCompany(sampleCompany);
      companyWithZeroSalaryObj = parseCompany(companyWithZeroSalary);
      companyWithNegSalaryObj = parseCompany(companyWithNegSalary);
   }

   /**
    * Normal test for determining the total salary of a JSON object and expecting that it is equal to a given value.
    */

   @Test
   public void testTotalNormalCase()
   {
      double total = total(sampleCompanyObj);
      assertEquals(326927.0, total, 0.0);
   }

   /**
    * Edge test for determining the total salary of a JSON object with zero salary.
    */

   @Test
   public void testTotalEdgeCase()
   {
      double total = total(companyWithZeroSalaryObj);
      assertEquals(total, 0.0, 0.0);
   }

   /**
    * Error test for determining the total salary of a JSON object with negative salary, which throws an Arithmetic Exception.
    */

   @Test(expected = ArithmeticException.class)
   public void testTotalErrorCase()
   {
      total(companyWithNegSalaryObj);
   }
}