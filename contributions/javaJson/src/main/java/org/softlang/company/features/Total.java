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
    * Method searching for a value which type is of JsonValue.NUMBER. If the key of the given value is equals to SALARY the amount of val1 is added to sum.
    * If the type of value is equal to JsonValue.OBJECT or JsonValue.ARRAY it iterates over array items or inner JSON objects and
    * starts a recursion to determine total salary of lower levels and adding it to sum.
    * All other values which are not suitable to the given value type are skipped.
    *
    * @param key1 key for the value at hand
    * @param val1 JSON value to traverse
    * @return salary total
    */
   private static double total(String key1, JsonValue val1)
   {
      double sum = 0;

      switch( val1.getValueType() )
      {
         case NUMBER:
            if( Optional.ofNullable(key1).isPresent() && key1.equals(SALARY) )
            {
               // Aggregate salaries
               Double salary = ((JsonNumber) val1).doubleValue();
               sum += salary;
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