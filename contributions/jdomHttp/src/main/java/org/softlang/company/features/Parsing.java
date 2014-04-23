package org.softlang.company.features;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.io.IOException;
import java.net.URL;

public class Parsing {

    public static Document parseCompany(String url) throws IOException, JDOMException {
        return new SAXBuilder().build(new URL(url).openStream());
    }

}