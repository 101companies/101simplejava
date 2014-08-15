package org.softlang.company.model;

public class Employee {
	private String name;
	private String address;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(String name, String address, double salary) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Person:\nName " + name + ": \nAddress: " + address
				+ "\nSalary: " + salary;
	}

}
