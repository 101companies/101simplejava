package org.softlang.company;

public class Employee {

    private final String name;
    private final Address address;
    private double salary;

    public Employee(String name, Address address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
