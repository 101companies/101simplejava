package org.softlang.company.model;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * A company has a name and consists of (possibly nested) departments.
 */
public class Company {

	private String name;
	private List<Department> depts = new LinkedList<Department>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepts() {
		return depts;
	}

	public boolean equals(Object obj) {
		   return EqualsBuilder.reflectionEquals(this, obj);
	}
	
}