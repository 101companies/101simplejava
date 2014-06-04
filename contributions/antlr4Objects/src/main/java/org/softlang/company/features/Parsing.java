package org.softlang.company.features;

import static org.softlang.company.antlr.CompanyParser.*;
import org.softlang.company.model.Company;

import org.antlr.v4.runtime.*;

import java.io.IOException;

public class Parsing {

    public static Company parse(String s)
            throws IOException, RecognitionException {
        /*
         * Parsing is implemented in the generated Parser
         * See src/main/antlr/Company.g
         */
        return parseCompany(s);
    }

}