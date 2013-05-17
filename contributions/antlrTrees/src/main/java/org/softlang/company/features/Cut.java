package org.softlang.company.features;

import org.softlang.company.antlr.TotalCompany;
import org.softlang.company.antlr.CutCompany;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import java.io.IOException;

public class Cut {

    public static CommonTree cut(CommonTree tree)
            throws IOException, RecognitionException {
        /*
         * Cut is implemented in the generated Parser
         * See src/main/antlr/CutCompany.g
         */
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        CutCompany cut = new CutCompany(nodes);
        CommonTree cutTree = (CommonTree)cut.downup(tree);
        return cutTree;
    }

}