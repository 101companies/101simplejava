package org.softlang.company.features;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public class Cut
{
   private static final String SALARY = "salary";

   /**
    * Executes the cut method for every key-Object in obj.keySet() and the suitable object. Returns the updated JSON object.
    *
    * @param obj input JSON object
    * @return output updated JSON object
    */
   public static JsonObject cut(JsonObject obj)
   {
      JsonObjectBuilder builder = Json.createObjectBuilder();

      obj.keySet().forEach(key -> cut(builder, key, obj.get(key)));

      return builder.build();
   }

   /**
    * Executes the cut method for every item of arr-parameter. Returns the updated JSON array object.
    *
    * @param arr input JSON array
    * @return updated output JSON array
    */
   public static JsonArray cut(JsonArray arr)
   {
      JsonArrayBuilder builder = Json.createArrayBuilder();

      arr.forEach(item -> cut(builder, item));

      return builder.build();
   }

   /**
    * Method searching for a value which type is of JsonValue.NUMBER. Then halve the value and add it to the builder-object.
    * If the type of value is equal to JsonValue.OBJECT or JsonValue.ARRAY it starts a recursion and going a level deeper.
    * Else if none of the given types is suitable to the value type then just change nothing and add it to the builder-object.
    *
    * @param builder An object builder to which to add to
    * @param key     A key for the input value
    * @param val     The input value
    *
    * @throws ArithmeticException when a salary is negative
    */
   private static void cut(JsonObjectBuilder builder, String key, JsonValue val) throws ArithmeticException
   {
      switch( val.getValueType() )
      {
         case NUMBER:
            Double num = ((JsonNumber) val).doubleValue();
            if( key.equals(SALARY) )
            // Halve salary
            {
               if( num < 0 )
               {
                  throw new ArithmeticException();
               }
               else
               {
                  num /= 2;
               }
            }
            builder.add(key, num);
            break;
         case OBJECT:
            builder.add(key, cut((JsonObject) val));
            break;
         case ARRAY:
            builder.add(key, cut((JsonArray) val));
            break;
         default:
            builder.add(key, val);
            break;
      }
   }

   /**
    * Method decides depending on the value type which cut-method should be executed and adds the result to the builder-object.
    *
    * @param builder An array builder to which to add to
    * @param val     The input value
    */
   private static void cut(JsonArrayBuilder builder, JsonValue val)
   {
      switch( val.getValueType() )
      {
         case OBJECT:
            builder.add(cut((JsonObject) val));
            break;
         case ARRAY:
            builder.add(cut((JsonArray) val));
            break;
         default:
            builder.add(val);
            break;
      }
   }

}