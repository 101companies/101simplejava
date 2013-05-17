package org.softlang.company.features;

import org.softlang.company.features.recognizer.RecognitionException;
import org.softlang.company.features.recognizer.Recognizer;

import java.io.FileNotFoundException;

public class Parsing {

    public static void parse(String file) throws FileNotFoundException, RecognitionException {
        Recognizer lexer = new Recognizer(file);
        lexer.lexall();
    }

}