package org.softlang.company;

import org.junit.Before;
import org.junit.Test;
import rx.observables.BlockingObservable;
import rx.util.functions.Action1;

import rx.Observable;

import static org.junit.Assert.*;

public class CompanyTest {

    Company theCompany;

    @Before
    public void before() {
        theCompany = new Company("ACME Corporation");
        Department research = new Department("Research", new Employee("Craig", new Address("Redmond"), 123456.0));
        research.addEmployee(new Employee("Erik", new Address("Utrecht"), 12345.0));
        research.addEmployee(new Employee("Ralf", new Address("Koblenz"), 1234.0));
        theCompany.addDepartment(research);
        Department development = new Department("Development", new Employee("Ray", new Address("Redmond"), 234567.0));
        Department dev1 = new Department("Dev1", new Employee("Klaus", new Address("Boston"), 23456.0));
        Department dev11 = new Department("Dev1.1", new Employee("Karl", new Address("Riga"), 2345.0));
        dev11.addEmployee(new Employee("Joe", new Address("Wifi City"), 2344.0));
        dev1.addDepartment(dev11);
        development.addDepartment(dev1);
        theCompany.addDepartment(development);
    }

    @Test
    public void testTotal() {
        theCompany.total().subscribe(new Action1<Double>() {
            @Override
            public void call(Double aDouble) {
                assertEquals(aDouble, 399747.0, 1e-10);
            }
        });
    }

    @Test
    public void testCut() {
        BlockingObservable.from(Observable.from(theCompany)).forEach(new Action1<Company>() {
            @Override
            public void call(Company company) {
                company.cut();
            }
        });

        theCompany.total().subscribe(new Action1<Double>() {
            @Override
            public void call(Double aDouble) {
                assertEquals(aDouble, 399747.0 * 0.5, 1e-10);
            }
        });
    }
}
