package org.softlang;

import java.util.Observable;
import java.util.Observer;

import org.softlang.model.Employee;

/**
 * Created with IntelliJ IDEA.
 * User: Kevin
 * Date: 12.08.13
 * Time: 00:54
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Employee e = (Employee) o;
        System.out.printf("New salary of %s: %s%n", e.getName(), e.getSalary());

    }
}
