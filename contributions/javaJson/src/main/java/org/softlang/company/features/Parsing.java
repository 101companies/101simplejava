package org.softlang.company.features;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Parsing
{
   /**
    * Method reads the given file and convert it to a suitable JSON object; then returns it.
    *
    * @param file JSON file with object structure
    * @return JsonObject with read object structure
    * @throws IOException
    */

   public static JsonObject parseCompany(String file) throws IOException
   {
      InputStream fis = new FileInputStream(file);
      JsonReader jsonReader = Json.createReader(fis);
      JsonObject jsonObject = jsonReader.readObject();
      jsonReader.close();
      fis.close();
      return jsonObject;
   }

}