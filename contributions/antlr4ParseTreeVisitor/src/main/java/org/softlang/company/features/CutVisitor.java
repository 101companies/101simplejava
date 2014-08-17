package org.softlang.company.features;


import org.antlr.v4.runtime.*;
import org.softlang.company.antlr.CompanyBaseVisitor;
import org.softlang.company.antlr.CompanyParser.EmployeeContext;


public class CutVisitor extends CompanyBaseVisitor<Void> {

	@Override
	public Void visitEmployee(EmployeeContext ctx) {
/*
 *  We rely on the named token salary in Company.g4,
 *  which yields us the member ctx.salary
 */
		CommonToken s = (CommonToken) ctx.salary;
		s.setText(Float.toString(Float.parseFloat(s.getText()) / 2.0f));
		return null;

	}

}
