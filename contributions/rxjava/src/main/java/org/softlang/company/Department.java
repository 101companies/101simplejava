package org.softlang.company;

import rx.Observable;
import rx.util.functions.Action1;
import rx.util.functions.Func1;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private final String name;
    private Employee manager;
    private final List<Employee> employees;
    private final List<Department> subDepts;

    public Department(String name, Employee manager) {
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.subDepts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addDepartment(Department dept) {
        subDepts.add(dept);
    }

    public Observable<Double> total() {
        Observable<Double> employeeResult = Observable.from(employees).sumDouble(new Func1<Employee, Double>() {
            @Override
            public Double call(Employee employee) {
                return employee.getSalary();
            }
        });

        Observable<Double> departmentResult = Observable.sumDouble(
                Observable.from(subDepts).flatMap(new Func1<Department, Observable<? extends Double>>() {
                    @Override
                    public Observable<? extends Double> call(Department department) {
                        return department.total();
                    }
                }));

        return Observable.merge(employeeResult, departmentResult, Observable.from(manager.getSalary()));
    }

    public void cut() {
        Observable.from(employees).subscribe(new Action1<Employee>() {
            @Override
            public void call(Employee employee) {
                employee.setSalary(employee.getSalary() * 0.5);
            }
        });

        Observable.from(subDepts).subscribe(new Action1<Department>() {
            @Override
            public void call(Department department) {
                department.cut();
            }
        });
        Observable.from(manager).subscribe(new Action1<Employee>() {
            @Override
            public void call(Employee employee) {
                employee.setSalary(employee.getSalary() * 0.5);
            }
        });
    }
}
