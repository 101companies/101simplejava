package org.softlang.company.features;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.model.Company;

public class CompanyBuilder implements UnitBuilder {

	private Company company = new Company();
	private List<DepartmentBuilder> departments = new LinkedList<DepartmentBuilder>();

	public CompanyBuilder company(String name) {
		company.setName(name);
		return this;
	}

	public DepartmentBuilder department(String name) {
		DepartmentBuilder child = new DepartmentBuilder(this);
		departments.add(child);
		child.setName(name);
		return child;
	}

	public UnitBuilder endDepartment() {
		// Already on top level
		return this;
	}

	@Override
	public Company endCompany() {
		for(DepartmentBuilder builder : departments){
			company.getDepts().add(builder.getContent());
		}
		return company;
	}

}
