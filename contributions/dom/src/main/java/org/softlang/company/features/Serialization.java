package org.softlang.company.features;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Serialization {

	/**
	 * Parse a file and return the Document object
	 */
	public static Document loadDocument(String filename) {
		try {
			// Create a builder factory
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			// Create the builder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Deserialization by parsing
			Document doc = builder.parse(new File(filename));

			// Done
			return doc;

		} catch (SAXException e) {
		} catch (ParserConfigurationException e) {
		} catch (IOException e) {
		}
		// Return null for any sort of problem
		return null;
	}

	/**
	 * Save a document to a file.
	 */
	public static boolean saveDocument(Document doc, String filename) {

		try {
			// Prepare the DOM document for writing
			Source source = new DOMSource(doc);

			// Prepare the output file
			File file = new File(filename);
			Result result = new StreamResult(file);

			// Creater a transformer factory
			TransformerFactory xfactory = TransformerFactory.newInstance();

			// Create a transformer
			Transformer transformer = xfactory.newTransformer();

			// Force pretty printing
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			// Serialization by transformation
			transformer.transform(source, result);

			// Done
			return true;

		} catch (TransformerConfigurationException e) {
		} catch (TransformerException e) {
		}
		// Return false for any sort of problem
		return false;
	}

	/**
	 * Construct a new document
	 */
	public static Document createDocument() {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder;
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {
		}
		return null;
	}

	/**
	 * return true if document is a valid company
	 * 
	 */
	public static boolean isValidXml(String xmlFile, String xsdFile) {
		Schema schema = null;
		// Create a builder factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setNamespaceAware(true);

		// Create a factory for validation
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory schemaFactory = SchemaFactory.newInstance(language);

		try {
			// Create schema from xsd file
			schema = schemaFactory.newSchema(new File(xsdFile));
			// Create validator
			Validator validator = schema.newValidator();
			// Create DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Create document from xml file
			Document doc = builder.parse(new File(xmlFile));
			// validate xml file with xsd schema
			validator.validate(new DOMSource(doc));
			return true;
		} catch (SAXException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} catch (ParserConfigurationException e) {
			System.err.println(e);
		}
		return false;
	}
}