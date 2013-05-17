package org.softlang.company.features;

import static org.softlang.company.features.recognizer.Token.*;
import org.softlang.company.features.recognizer.Token;
import org.softlang.company.features.recognizer.Recognizer;

import java.io.FileNotFoundException;

public class Total {

    public static double total(String s) throws FileNotFoundException {
        double total = 0;
        Recognizer recognizer = new Recognizer(s);
        Token current = null;
        Token previous = null;
        while (recognizer.hasNext()) {
            current = recognizer.next();
            if (current==FLOAT && previous==SALARY) 
                total += Double.parseDouble(recognizer.getLexeme());
            previous = current;
        }
        return total;
    }

}