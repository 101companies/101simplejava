package org.softlang.company.tests;

import java.io.IOException;
import javax.json.JsonObject;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.Cut.cut;
import static org.softlang.company.features.Parsing.parseCompany;
import static org.softlang.company.features.Total.total;
import static org.softlang.company.tests.ParsingTest.companyWithNegSalary;
import static org.softlang.company.tests.ParsingTest.companyWithZeroSalary;
import static org.softlang.company.tests.ParsingTest.sampleCompany;

public class CutTest
{
   private JsonObject sampleCompanyObj;
   private JsonObject companyWithZeroSalaryObj;
   private JsonObject companyWithNegSalaryObj;

   /**
    * Initialization of a JSON object for tests
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
    * Normal test for cutting salaries of a sample company JSON.
    * The total salary "total1" is compared to the total salary after it has been cut "total2".
    * It's expected that total2 should be the half of total1 after executing the cut method.
    */

   @Test
   public void testCutNormalCase()
   {
      double total1 = total(sampleCompanyObj);
      double total2 = total(cut(sampleCompanyObj));
      assertEquals(total1 / 2, total2, 0.0);
   }

   /**
    * Edge test for cutting the salary of a company with zero salary.
    * The expected result is zero.
    */

   @Test
   public void testCutEdgeCase()
   {
      double total = total(cut(companyWithZeroSalaryObj));
      assertEquals(total / 2, 0.0, 0.0);
   }

   /**
    * Error test for cutting the salary of a company with negative salary which throws an Arithmetic Exception.
    */

   @Test(expected = ArithmeticException.class)
   public void testCutErrorCase()
   {
      double total = total(cut(companyWithNegSalaryObj));
   }
}