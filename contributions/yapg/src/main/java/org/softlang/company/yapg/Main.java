package org.softlang.company.yapg;

import org.softlang.company.grammar.Grammar;
import org.softlang.company.grammar.GrammarLexer;
import org.softlang.company.grammar.GrammarParser;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * CLI access to YAPG
 */
public class Main {

    public static void main(String[] args) throws IOException, RecognitionException {
        String path = args[0];
        String pkg = args[1];
        String stem = args[2];
        FileInputStream stream = new FileInputStream(path + File.separatorChar + stem + ".yapg");
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        GrammarLexer lexer = new GrammarLexer(antlr);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        Grammar g = parser.parseGrammar();
        if (parser.error) throw new RecognitionException();
        Generator.generate(path, pkg, stem, g);
    }

}