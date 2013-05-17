package org.softlang.company.features;

import org.softlang.company.features.recognizer.Acceptor;
import org.softlang.company.features.recognizer.Parser;

import java.io.FileNotFoundException;

public class Parsing {

    public static void accept(String file) throws FileNotFoundException {
        Acceptor a = new Acceptor();
        a.accept(file);
	}

	public static void parse(String file) throws FileNotFoundException {
        Parser p = new Parser();
        p.parse(file);
	}

}