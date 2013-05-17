package org.softlang.company.features;

import static org.softlang.company.features.dom.DOMUtilities.*;

import org.w3c.dom.Document;

public class Unparsing {

    public static void unparseDocument(Document doc, String file) throws Exception {
        saveDocument(doc, file);
    }

}