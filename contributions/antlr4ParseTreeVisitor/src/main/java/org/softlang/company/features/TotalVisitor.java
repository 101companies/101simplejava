package org.softlang.company.features;

import org.antlr.v4.runtime.misc.NotNull;
import org.softlang.company.antlr.CompanyBaseVisitor;
import org.softlang.company.antlr.CompanyParser;

public class TotalVisitor extends CompanyBaseVisitor<Float> {
	
	@Override public Float visitEmployee(@NotNull CompanyParser.EmployeeContext ctx) { 
		
		return Float.valueOf(ctx.salary.getText());
		
		}
	@Override
	protected Float aggregateResult(Float aggregate, Float nextResult) {
		if (aggregate==null) return nextResult;
		else if (nextResult==null) return aggregate;
		else return aggregate+nextResult; 
	}

}
