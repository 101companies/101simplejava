package org.softlang.company.features;

import org.antlr.v4.runtime.misc.NotNull;
import org.softlang.company.antlr.CompanyBaseListener;
import org.softlang.company.antlr.CompanyParser;

public class TotalListener extends CompanyBaseListener {
	private float total = 0;
	private CompanyParser parser = null;

	public TotalListener(CompanyParser parser) {
		// Eigentlich brauchen wir den parser hier noch nicht
		this.parser = parser;
	}

	public float getTotal() {
		return total;
	}

	@Override
	public void enterEmployee(@NotNull CompanyParser.EmployeeContext ctx) {
		// All FLOATS are salaries
		total += Float.parseFloat(ctx.FLOAT().getText());
	}

}
