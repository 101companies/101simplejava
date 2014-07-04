package org.softlang.company.messages;

import org.softlang.company.model.Company;

public class CutMessage {
	private Company c;

	public CutMessage(Company c) {
		this.c = c;
	}

	public Company getCompany() {
		return c;
	}

	public void setCompany(Company c) {
		this.c = c;
	}

}
