package org.softlang.company.features;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.features.parsing.Recognizer;
import org.softlang.company.features.parsing.Token;

import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * For clarification, this is precise copy and
 * only shows the idea of Unparsing (noop copy).
 */
public class Unparsing {

    public static void copy(String in, String out) throws IOException {
        Recognizer recognizer = recognizeCompany(in);
        Writer writer = new OutputStreamWriter(new FileOutputStream(out));
        String lexeme = null;
        Token current = null;
        while (recognizer.hasNext()) {
            current = recognizer.next();
            lexeme = recognizer.getLexeme();
            // noop
            // write
            writer.write(lexeme);
        }
        writer.close();
    }

}