package org.softlang.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private List<Department> ds = new ArrayList<Department>();
	private String name;

	public Company(List<Department> ds, String name) {
		super();
		this.ds = ds;
		this.name = name;
	}

	public List<Department> getDs() {
		return ds;
	}

	public void setDs(List<Department> ds) {
		this.ds = ds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void cut() {
		for (Department d : ds) {
			d.cut();
		}
	}
	
	public double total() {
		int total = 0;
		for (Department d: ds) {
			total += d.total();
		}
		return total;	
	}

}
