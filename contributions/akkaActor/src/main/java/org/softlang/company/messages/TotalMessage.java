package org.softlang.company.messages;

import org.softlang.company.model.Company;

public class TotalMessage {
	private Company c;

	public TotalMessage(Company c){
		this.c = c;
	}
	
	public Company getCompany() {
		return c;
	}

	public void setCompany(Company c) {
		this.c = c;
	}
	
}
