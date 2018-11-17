package org.softlang.company.features;

import java.util.Optional;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonValue;

public class Total
{
   private static final String SALARY = "salary";

   /**
    * Executes total-method with null as key and the given JSON object.
    *
    * @param obj JSON object to traverse
    * @return salary total
    */
   public static double total(JsonObject obj)
   {
      return total(null, obj);
   }

   /**
    * Method which adds up numeric values of a "salary" key.
    * If it encounters a value of type json object or json array recursively goes deeper and searches for numeric values to determine the total salary.
    * Otherwise if none of the given types match the value type the key-value pair is skipped.
    *
    * @param key1 key for the value at hand
    * @param val1 JSON value to traverse
    * @return salary total
    *
    * @throws ArithmeticException when a salary is negative
    */
   private static double total(String key1, JsonValue val1) throws ArithmeticException
   {
      double sum = 0;

      switch( val1.getValueType() )
      {
         case NUMBER:
            if( Optional.ofNullable(key1).isPresent() && key1.equals(SALARY) )
            {
               // Aggregate salaries
               Double salary = ((JsonNumber) val1).doubleValue();
               if( salary < 0 )
               {
                  throw new ArithmeticException();
               }
               else
               {
                  sum += salary;
               }
            }
            // Otherwise skip numbers
            break;

         case ARRAY:
            // Iterate over array items and adding aggregated value to sum
            sum += ((JsonArray) val1)
                  .stream()
                  .map(item -> total(key1, item))
                  .reduce(0.0, (t1, t2) -> t1 + t2);

            break;

         case OBJECT:
            // Iterate over inner JSON objects and adding aggregated value to sum
            JsonObject obj = (JsonObject) val1;

            obj.keySet()
                  .stream()
                  .map(key2 -> total(key2, obj.get(key2)))
                  .reduce(0.0, (t1, t2) -> t1 + t2);

            break;

         default:
            // Skip all other values
            break;
      }

      return sum;
   }

}