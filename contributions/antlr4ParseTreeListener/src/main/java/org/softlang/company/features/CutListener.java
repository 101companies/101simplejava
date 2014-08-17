package org.softlang.company.features;

import java.io.PrintStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.softlang.company.antlr.CompanyBaseListener;
import org.softlang.company.antlr.CompanyParser;
import org.softlang.company.antlr.CompanyParser.EmployeeContext;

public class CutListener extends CompanyBaseListener {

	public CutListener(PrintStream out) {
		this.out = out;
	}

	private PrintStream out = System.out;

	@Override
	public void exitEmployee(EmployeeContext ctx) {
		out.println(); // just to avoid long lines
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() != CompanyParser.EOF) {
			String f = node.getText();
			if (node.getSymbol().getType() == CompanyParser.FLOAT)
				out.print(Float.valueOf(f) / 2.0 + " ");
			else
				out.print(f + " ");
		}
	}

}
