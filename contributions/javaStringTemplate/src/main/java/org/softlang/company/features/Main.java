package org.softlang.company.features;

import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

public class Main {
	public static void main(String[] args) {
		Company c = new Company("Uni");
		Department d1 = new Department("Softlang", new Employee("Ralle", "",
				4000.0));
		d1.addEmployee(new Employee("Andre", "", 2222));
		c.addDepartment(d1);
		Department d2 = new Department("OOPM", new Employee("Manfred", "",
				2000.0));
		d2.addEmployee(new Employee("Michael", "", 222));
		d2.addEmployee(new Employee("Matthias", "", 333));
		d2.addEmployee(new Employee("Tim", "", 444));
		d2.addEmployee(new Employee("Madlene", "", 555));
		d1.addSubDepartment(d2);
		Department d3 = new Department("PTT",
				new Employee("Jackel", "", 2000.0));
		d3.addEmployee(new Employee("Monschau", "", 222));
		d3.addEmployee(new Employee("Paul", "", 333));
		d3.addEmployee(new Employee("Erwin", "", 444));

		d1.addSubDepartment(d3);
		System.out.println(Unparsing.unparse(c, "text.Company"));
	}
}
