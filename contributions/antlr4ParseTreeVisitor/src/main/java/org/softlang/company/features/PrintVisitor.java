package org.softlang.company.features;

import java.io.PrintStream;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.softlang.company.antlr.CompanyBaseVisitor;
import org.softlang.company.antlr.CompanyParser.*;

import org.softlang.company.antlr.CompanyParser.DepartmentContext;
import org.softlang.company.antlr.CompanyParser.EmployeeContext;

public class PrintVisitor extends CompanyBaseVisitor<Void> {
	
	PrintStream out;
	
	public PrintVisitor(PrintStream out) {
		this.out=out;
	}
	
	public PrintVisitor() {
		this.out=System.out;
	}

	@Override
	public Void visitCompany(CompanyContext ctx) {
		ParseTree c;
		for (int i = 0; i < ctx.getChildCount() - 1; i++)
			if ((c = ctx.getChild(i)) instanceof TerminalNodeImpl)
				out.print(c.getText() + " ");
			else
				visit(c);
		return null;
	}

	@Override
	public Void visitDepartment(DepartmentContext ctx) {
		for (ParseTree c : ctx.children)
			if (c instanceof TerminalNodeImpl)
				out.print(c + " ");
			else
				visit(c);
		return null;

	}

	@Override
	public Void visitEmployee(EmployeeContext ctx) {
		for (ParseTree c : ctx.children)
			out.print(c + " ");
		return null;

	}

}
