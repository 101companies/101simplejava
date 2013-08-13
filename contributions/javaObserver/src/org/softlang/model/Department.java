package org.softlang.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private List<Department> ds = new ArrayList<Department>();
	private List<Employee> es = new ArrayList<Employee>();
	private Employee manager;
	private String name;

	public Department(List<Employee> es, List<Department> ds, Employee manager,
			String name) {
		super();
		this.ds = ds;
		this.es = es;
		this.manager = manager;
		this.name = name;
	}

	public List<Department> getDs() {
		return ds;
	}

	public void setDs(List<Department> ds) {
		this.ds = ds;
	}

	public List<Employee> getEs() {
		return es;
	}

	public void setEs(List<Employee> es) {
		this.es = es;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void cut() {
		manager.cut();
		for (Employee e : es) {
			e.cut();
		}
		for (Department d : ds) {
			d.cut();
		}
	}
	
	public double total() {
		double total = manager.total();
		for (Employee e : es) {
			total += e.total();
		}
		for (Department d : ds) {
			total += d.total();
		}
		return total;

	}


}
