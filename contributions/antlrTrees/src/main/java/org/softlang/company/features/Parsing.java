package org.softlang.company.features;

import static org.softlang.company.antlr.CompanyParser.*;
import org.softlang.company.antlr.CompanyLexer;
import org.softlang.company.antlr.CompanyParser;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Parsing {

    public static CommonTree parse(String s)
            throws IOException, RecognitionException {
        /*
         * Parsing is implemented in the generated Parser
         * See src/main/antlr/Company.g
         */
        CommonTree t = (CommonTree)parseCompany(s).getTree();
        return t;
    }

}