#This is an implementation of the 101companies System.

## Headline: 
Process JSON data with Java's javax.json API

## Characteristics: 
See Contribution:dom and Contribution:jdom for a general motivation for exercising in-memory XML processing. 
The present contribution simply commits to JSON instead of XML.

## Illustration: 
####Code snippet 1 (Lambda Expression):
```
obj.keySet().forEach(key -> cut(builder, key, obj.get(key)));
```
This snippet iterates over all keys of a key set and calls the cut method on each key. 

####Code snippet 2 (Stream API + Fluent API):
```
sum += ((JsonArray) val1)
        .stream()
        .map(item -> total(key1, item))
        .reduce(0.0, (t1, t2) -> t1 + t2);
```
This snippet transforms an object of type JsonArray to a stream and 
applies the total method on each item of the stream. Starting with zero, 
the result of the total method is recursively added to the next item in the stream. 
The result is the sum of all values returned by the total method. 

####Code snippet 3 (Parsing JSON file):
```
  public static JsonObject parseCompany(String file) throws IOException
   {
      JsonReader jsonReader = Json.createReader(new FileInputStream(file));
      JsonObject jsonObject = jsonReader.readObject();
      jsonReader.close();
      return jsonObject;
   }
```
This snippet creates a JsonReader and reads a given JSON file to create a JsonObject.


## Relationships: 
Similar methods are used in the Contribution:javaJsonHttp.
Contribution:javaJsonHttp uses HTTP-based access to the input data instead of going through the file system.

## Architecture: 
The contribution is built with the gradle build system so it corresponds to its standard architecture.
Classes for production are localed in the main directory and classes for test are localed in the test directory.
Json files are found in the inputs directory.

## Usage: 
This contribution is built using Gradle, check [this](https://docs.gradle.org/current/userguide/embedding.html) site for an offical plugin for your IDE. 
When using an official Plugin, just download this repo and import the contribution with your IDE.

## Metadata: 
      Cotribution:javaJson
      Language:Java10
      Technology:javax.json
      Technology:Lambda Expression
      Technology:Stream API
      Technology:Fluent API
      Feature:Company
      Feature:Total
      Feature:Cut
      Feature:Serialization

See also: [javax.json documentation](https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html), [java stream API documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html), [java lambda expressions tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

Documentation: http://101companies.org/wiki/Contribution:javaJson

Build instructions: https://github.com/101companies/101simplejava
