package org.softlang.company.features;

import static org.softlang.company.features.dom.DOMUtilities.*;

import org.w3c.dom.Document;

public class Parsing {

    public static Document parseDocument(String file) throws Exception {
        return loadDocument(file);
    }

}