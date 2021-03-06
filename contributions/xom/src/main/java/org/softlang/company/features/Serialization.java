package org.softlang.company.features;

import nu.xom.Builder;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

import java.io.File;
import java.io.IOException;

public class Serialization {

    public static Element deserializeCompany(String file) throws ValidityException, ParsingException, IOException {
        return (new Builder().build(new File(file)).getRootElement());
    }

}