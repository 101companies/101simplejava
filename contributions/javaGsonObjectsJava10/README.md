This is an implementation of the 101companies System.

== Headline ==
Working on [[Language:JSON|]] with Google [[Technology:Gson|Gson API]], mapping Json to a direct object representation

== Characteristics ==
This contribution modernizes the [[Contribution:javaGsonObjects]] (which is a simple company structure, displaying the serialization process using [[Language:JSON]] for storing the company structure and Gson API for parsing, unparsing and manipulating it the JSON.), by utilizing new features, introduced up to Java10, such as [[Concept:Lambda abstraction]] and [[Concept:Streaming]].

== Illustration ==
To Parse a JSON File you can either use "parseFromFile(String path)" or "parseFromFile(File file)"
The former is only a wrapper method for the latter, so we'll be taking a look at the "parseFromFile(File file)" method.
<syntaxhighlight lang="java">
	/**
	 * Method to parse a JSON file to a Company
	 * 
	 * @param file Path for JSON file
	 * @return a Company representing the JSON file
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static Company parseFromFile(File file) throws FileNotFoundException, IOException {
		Gson gson = new Gson();
		try (JsonReader read = new JsonReader(new FileReader(file))) {
			return gson.fromJson(read, Company.class);
		}
	}
</syntaxhighlight>
Given a JSON file, the method will create a Gson object and attempt to read the file using a JsonReader.
Should the file not be found, the method will throw a FileNotFoundException.
Were there problems reading the File, then an IOException will be thrown.
The method will proceed to the last instuction if the file was read without any problems.
<code>gson.fromJson(read, Company.class);</code>
Here, the "fromJson" method of the gson object, is parsing the read JSON data into an object of type Company.
Alternatively, you can call the "parse(String jsonString)" method directly, if you have already read the JSON file into a string.
<syntaxhighlight lang="java">
	/**
	 * Method to parse a JSON String to a Company
	 * 
	 * @param jsonString String containing JSON
	 * @return a Company representing the JSON from the jsonString
	 */
	public static Company parse(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, Company.class);
	}
</syntaxhighlight>

The Unparsing methods are very similar to the parsing ones.
Like in the Parsing class, we defined a wrapper function for the parameter path.
The "unparseToFile(Company company, File file)" method looks as follows:
<syntaxhighlight lang="java">
	/**
	 * Method to parse a Company to a JSON File
	 * 
	 * @param company Company to be parsed to a JSON File
	 * @param file    Destination File for the JSON File
	 * @throws IOException
	 */
	public static void unparseToFile(Company company, File file) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(company, writer);
		}
	}
</syntaxhighlight>
Let us take a closer look into it's inner workings.
The line...
<code> GsonBuilder builder = new GsonBuilder();</code>
...leaves us with a GsonBuilder object, which will serve the purpose of creating the gson object we'll be using to create and write the JSON file with.
We then proceed in creating a FileWriter object via a try-with-resources statement.
<syntaxhighlight lang="java">
    try (FileWriter writer = new FileWriter(file)) {
        gson.toJson(c, writer);
    }
</syntaxhighlight>
The FileWriter is then used by the gson object to write the JSON representation of the company into the file given by the user.

The string representation of a company object in the JSON format can be obtained directly, without being written to a file, by the "unparse(Company company)" method.
<syntaxhighlight lang="java">
	/**
	 * Method to parse a Company to a JSON String
	 * 
	 * @param company Company to be parsed to a JSON File
	 * @return a String representing the JSON File of the company
	 */
	public static String unparse(Company company) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(company);
	}
</syntaxhighlight>

== Relationships ==
[[Contribution:javaGsonObjects] is the base for this contribution.
[[Contribution:javaGson]] is using the same Api and Features with a different JSON mapping.

== Architecture ==
The contribution follows a standardized structure:
* inputs contains input files for tests
* src/main/java contains the following packages:
** org.softlang.company.model for implementations of [[Feature:Hierarchical company]].
** org.softlang.company.features for implementations of [[Namespace:Feature]].
* src/test/java contains the following packages:
** org.softlang.company.tests for [[Technology:JUnit]] test cases for [[Namespace:Feature]]s.

== Usage ==
This contribution uses [[Technology:Gradle]] for building. [[Technology:Eclipse]] is supported.
See: https://github.com/101companies/101simplejava/blob/master/README.md

== Metadata ==
* [[developedBy::Contributor:mpaul138]]
* [[implements::Feature:Hierarchical company]]
* [[implements::Feature:Unparsing]]
* [[implements::Feature:Parsing]]
* [[implements::Feature:Total]]
* [[implements::Feature:Cut]]
* [[implements::Feature:Mapping]]
* [[implements::Feature:Serialization]]
* [[memberOf::Theme:Java mapping]]
* [[uses::Language:JSON]]
* [[uses::Language:Plain Text]]
* [[uses::Language:Java]]
* [[uses::Technology:Gson]]
* [[uses::Technology:JUnit]]
* [[uses::Technology:Gradle]]
