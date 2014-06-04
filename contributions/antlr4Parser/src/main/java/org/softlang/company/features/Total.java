package org.softlang.company.features;

import org.softlang.company.antlr.CompanyParser;
import org.softlang.company.features.Parsing;

import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Total {

    public static double total(String s)
            throws IOException, RecognitionException {
        /* 
         * Total is implemented by the generated Parser 
         * See src/main/antlr/Company.g
         */
        CompanyParser parser = Parsing.parse(s);
        return parser.total;
    }

}