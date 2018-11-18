== Headline ==

[[Object-XML mapping]] with [[Technology:JAXB|]] and newly incorporated [[Language:Java 8|]] [[Namespace:Feature]]s

== Characteristics ==

This contribution is an overhaul of [[Contribution:jaxbComposition]] which applies new [[Namespace:Feature]]s introduced with [[Language:Java 8|]] such as [[Feature:Lambda Expressions]], [[Feature:Method references]] and [[Feature:Streams]]. The general idea behind this modernization is to update all necessary project dependencies, improve code readability and represent code in a more functional fashion by applying the newly introduced [[Language:Java 8|]] [[Namespace:Feature]]s.

== Illustration ==

[[Feature:Open serialization]] is implemented using [[Technology:JAXB]] Un-/Marshaller. Furthermore the code has been reduced by employing Method chaining:

<fragment url="src/main/java/org/softlang/company/features/Serialization.java/class/Serialization/method/deserializeCompany"/>

 public static Company deserializeCompany(File input)
    throws JAXBException 
    {	
        initializeJaxbContext();
        return (Company) jaxbContext.createUnmarshaller().unmarshal(input);
    }

<fragment url="src/main/java/org/softlang/company/features/Serialization.java/class/Serialization/method/serializeCompany"/>


public static void serializeCompany(File output, Company c)
    throws     JAXBException,
            FileNotFoundException,
            XMLStreamException 
    {
    	initializeJaxbContext();
    	XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream(output));
        jaxbContext.createMarshaller().marshal(c, writer); 
    }

[[Feature:Total]] features [[Feature:Streams]] as a way of processing elements and [[Feature:Cut]] relies on Optionals for dealing with possible null values:

<fragment url="src/main/java/org/softlang/company/features/Total.java/class/Total"/>

public static double total(Department department) {
		
		double total = Optional.ofNullable(department.getManager()).map(Employee::getSalary).orElse(0.0);
		
		total += department.getDepartment()
						   .stream()
						   .map(dep -> total(dep))
						   .reduce(0.0, Double::sum);
		
		return total += department.getEmployee()
								  .stream()
								  .map(emp -> emp.getSalary())
								  .reduce(0.0, Double::sum);
	}


<fragment url="src/main/java/org/softlang/company/features/Cut.java/class/Cut"/>

public static void cut(Company company) {
		Optional.ofNullable(company)
				.map(Company::getDepartment)
				.ifPresent(depts -> depts.forEach(Cut::cut));
	}

Test cases are implemented for all [[Namespace:Feature]]s.

== Relationships ==

For Object/XML mapping see [[Contribution:jaxbChoice]] (XSD with choice for different subunits), [[Contribution:jaxbComposition]] (XSD with object composition), [[Contribution:jaxbExtension]] (XSD with type extension) and [[Contribution:jaxbSubstitution]] (XSD with substitution groups).

== Architecture ==

The contribution follows a standardized structure:
* inputs contains input files for tests
* src/main/java contains the following packages:
** org.softlang.company.features for implementations of [[Functional requirements]].
* src/test/java contains the following packages:
** org.softlang.company.tests for [[Technology:JUnit]] test cases for [[Namespace:Feature]]s.

== Usage ==

This contribution uses [[Technology:Gradle]] for building. [[Technology:Eclipse]] is supported.

See https://github.com/101companies/101simplejava/blob/master/README.md

== Metadata ==

* [[implements::Feature:Hierarchical company]]
* [[implements::Feature:Mapping]]
* [[implements::Feature:Open serialization]]
* [[implements::Feature:Total]]
* [[implements::Feature:Cut]]
* [[memberOf::Theme:Java mapping]]
* [[memberOf::Theme:XML programming]]
* [[uses::Language:Java]]
* [[uses::Language:XML]]
* [[uses::Language:XSD]]
* [[uses::Technology:JAXB]]
* [[uses::Technology:xjc]]
* [[uses::Technology:JUnit]]
* [[uses::Technology:Gradle]]
* [[uses::Concept:Lambdaware]]


