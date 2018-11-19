package org.softlang.company.tests;

import java.io.File;
import java.io.IOException;
import javax.json.JsonException;
import javax.json.JsonObject;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.softlang.company.features.Parsing.parseCompany;

public class ParsingTest
{

   public static String sampleCompany = "inputs" + File.separator + "sampleCompany.json";
   public static String companyWithZeroSalary = "inputs" + File.separator + "companyWithZeroSalary.json";
   public static String companyWithNegSalary = "inputs" + File.separator + "companyWithNegSalary.json";
   public static String emptyCompany = "inputs" + File.separator + "emptyCompany.json";
   public static String emptyFile = "inputs" + File.separator + "emptyFile.json";
   public static String nonExistentCompany = "";


   /**
    * Normal test for reading a sample company JSON and asserting that it is not null.
    */

   @Test
   public void testParsingNormalCase() throws IOException
   {
      JsonObject sampleCompanyObject = parseCompany(sampleCompany);
      assertNotNull(sampleCompanyObject);
   }

   /**
    * Edge test for reading a sample company JSON which is empty but not null.
    * @throws IOException
    */
   @Test
   public void testParsingEdgeCase() throws IOException
   {
      JsonObject emptyCompanyObject = parseCompany(emptyCompany);
      assertNotNull(emptyCompanyObject);
   }

   /**
    * Error test for reading a JSON file which is empty. Throws a JsonException.
    * @throws IOException
    */
   @Test(expected = JsonException.class)
   public void testParsingErrorCase1() throws IOException
   {
      parseCompany(emptyFile);
   }

   /**
    * Error test which simply tries to read a non existing JSON file and throws an IOException.
    *
    * @throws IOException
    */

   @Test(expected = IOException.class)
   public void testParsingErrorCase2() throws IOException
   {
      parseCompany(nonExistentCompany);
   }
}