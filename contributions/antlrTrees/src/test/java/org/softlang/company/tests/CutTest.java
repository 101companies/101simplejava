package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CutTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testCut()
            throws RecognitionException, IOException {
        CommonTree tree = parse(sampleCompany);
        CommonTree cutTree = cut(tree);
        double total = total(cutTree);
        assertEquals(399747 / 2.0d, total, 0);
    }

}