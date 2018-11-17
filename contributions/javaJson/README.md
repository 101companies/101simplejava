#This is an implementation of the 101companies System.

## Headline: 
Process JSON data with Java's javax.json API

## Characteristics: 
This contribution shows a way to read .json files with the javax.json API.
In combination with this it uses Java 11 standards such as lambda expressions and streams.
The advantages of using these technologies are that the code is more compact 
and iterations over collections with streams are easier.

## Illustration: 
####Code snippet 1:
```
obj.keySet().forEach(key -> cut(builder, key, obj.get(key)));
```
This snippet iterates over all keys of a key set and calls the cut method on each key. 

####Code snippet 2:
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


## Relationships: 
Similar methods are used in the javaJsonHttp contribution.
The only difference is that URLs are used to retrieve .json files instead of 
having them locally saved. 

## Architecture: 
The contribution is built with the gradle build system so it corresponds to its standard architecture.
Classes for production are localed in the main directory and classes for test are localed in the test directory.

## Usage: 
This contribution is built using Gradle, check [this](https://docs.gradle.org/current/userguide/embedding.html) site for an offical plugin for your IDE. 
When using an official Plugin, just download this repo and import the contribution with your IDE.

## Metadata: 
      Namespace:javaJson
      Namespace:Java10
      Namespace:javax.json
      Namespace:Lambda and Stream API

See also: [javax.json documentation](https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html), [java stream API documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html), [java lambda expressions tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

Documentation: http://101companies.org/wiki/Contribution:javaJson

Build instructions: https://github.com/101companies/101simplejava
