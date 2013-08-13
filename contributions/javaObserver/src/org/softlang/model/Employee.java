package org.softlang.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Employee extends Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private double salary;
	private String name;
	private String address;

	public Employee(double salary, String name, String address) {
		super();
		this.salary = salary;
		this.name = name;
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
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

	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : this.observers) {
			ob.update(this, null);
		}
	}

	public void cut() {
		salary /= 2;
		notifyObservers();
	}
	
	public double total() {
		return salary;
	}

}
