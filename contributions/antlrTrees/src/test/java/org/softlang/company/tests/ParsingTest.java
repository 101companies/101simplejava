package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ParsingTest {

    private static String posSample =
        "inputs"
        + File.separator
        + "sample.Company";
    private static String negSample =
        "inputs"
        + File.separator
        + "nonSample.Company";

    private static void printTree(CommonTree t) {
        printTree(t, 0);    
    }
    
    private static void indent(int indent) {
        for (int i=0; i<indent; i++)
            System.out.print("   ");
    }

    private static void printTree(CommonTree t, int indent) {
        if ( t != null ) {
            indent(indent);
            System.out.println(t.toString());
            for (int i = 0; i < t.getChildCount(); i++ ) {
                printTree((CommonTree)t.getChild(i), indent+1);
            }
        }
    }

    @Test
    public void testPositive()
            throws RecognitionException, IOException {
        CommonTree t = parse(posSample);
        printTree(t);
    }

    @Test(expected=RecognitionException.class)
    public void testNegative() throws IOException, RecognitionException {
        parse(negSample);
    }

}