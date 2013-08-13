package org.softlang;

import java.util.Vector;

import org.softlang.model.Company;
import org.softlang.model.Department;
import org.softlang.model.Employee;

public class Main {

	
	public static Company sample() {// Create company
    Company company = new Company(new Vector<Department>(), "");
    EmployeeObserver observer = new EmployeeObserver();
    
    // Create all employees
    Employee craig = new Employee(123456, "Craig", "Redmond");
    craig.addObserver(observer);
    Employee erik = new Employee(12345, "Erik", "Utrecht");
    erik.addObserver(observer);
    Employee ralf = new Employee(1234, "Ralf", "Koblenz");
    ralf.addObserver(observer);
    Employee ray = new Employee(234567, "Ray", "Redmond");
    ray.addObserver(observer);
    Employee klaus = new Employee(23456, "Klaus", "Boston");
    klaus.addObserver(observer);
    Employee karl = new Employee(2345, "Karl", "Riga");
    karl.addObserver(observer);
    Employee joe = new Employee(2344, "Joe", "Wifi City");
    joe.addObserver(observer);

    // Create research department
    Department research = new Department(new Vector<Employee>(), new Vector<Department>(), craig, "Research");
    research.getEs().add(erik);
    research.getEs().add(ralf);
    company.getDs().add(research);

    // Create development department
    Department development = new Department(new Vector<Employee>(), new Vector<Department>(), ray, "Development");
    company.getDs().add(development);

    // Create sub-department dev1
    Department dev1 = new Department(new Vector<Employee>(), new Vector<Department>(), klaus, "Dev1");
    development.getDs().add(dev1);

    // Create sub-department dev11
    Department dev11 = new Department(new Vector<Employee>(), new Vector<Department>(), karl, "Dev1.1");
    dev1.getDs().add(dev11);
    dev11.setName("Dev1.1");
    dev11.setManager(karl);
    dev11.getEs().add(joe);

    return company;
}

	
	public static void main(String[] args) throws Exception {
		Company mega = sample();
        mega.cut();
	}
}
