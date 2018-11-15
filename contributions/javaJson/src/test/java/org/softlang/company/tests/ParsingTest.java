package org.softlang.company.tests;

import java.io.File;
import java.io.IOException;
import javax.json.JsonObject;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.softlang.company.features.Parsing.parseCompany;

public class ParsingTest
{

   public static String sampleCompany = "inputs" + File.separator + "sampleCompany.json";
   public static String emptyCompany = "";


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
    * Error test which simply tries to read a non existing JSON file and throws an IOException.
    *
    * @throws IOException
    */

   @Test(expected = IOException.class)
   public void testParsingErrorCase() throws IOException
   {
      JsonObject emptyCompanyObject = parseCompany(emptyCompany);
   }
}