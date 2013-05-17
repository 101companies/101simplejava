package org.softlang.company.features;

import org.w3c.dom.Document;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parsing {

    /**
      * Parse a file and return the Document object
      */
    public static Document loadDocument(String filename) {
        try {
            // Create a builder factory
            DocumentBuilderFactory factory = 
                DocumentBuilderFactory.
                    newInstance();

            // Create the builder
            DocumentBuilder builder =
                factory.
                    newDocumentBuilder();

            // Deserialization by parsing
            Document doc =
                builder.
                    parse(new File(filename));

            // Done
            return doc;

        } catch (SAXException e) {
        } catch (ParserConfigurationException e) {
        } catch (IOException e) {
        }
        // Return null for any sort of problem
        return null;
    }

}