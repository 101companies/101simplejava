package org.softlang.company.features;

import org.softlang.company.antlr.TotalCompany;

import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.*;

import java.io.IOException;

public class Total {

    public static double total(CommonTree tree)
            throws IOException, RecognitionException {
        /*
         * Total is implemented in the generated Parser
         * See src/main/antlr/TotalCompany.g
         */
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        TotalCompany total = new TotalCompany(nodes);
        total.company();
        return total.total;
    }

}