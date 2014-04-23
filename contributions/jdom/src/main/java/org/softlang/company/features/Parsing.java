package org.softlang.company.features;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Parsing {

    public static Document parseCompany(String file) throws IOException, JDOMException {
        return new SAXBuilder().build(new File(file));
    }

}