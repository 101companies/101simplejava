package org.softlang.company;

import rx.Observable;
import rx.util.functions.Action1;
import rx.util.functions.Func1;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private final String name;
    private final List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public Observable<Double> total() {
        return Observable.sumDouble(Observable.from(departments).flatMap(new Func1<Department, Observable<Double>>() {
            @Override
            public Observable<Double> call(Department department) {
                return department.total();
            }
        }));
    }

    public void cut() {
        Observable.from(departments).subscribe(new Action1<Department>() {
            @Override
            public void call(Department department) {
                department.cut();
            }
        });
    }
}
