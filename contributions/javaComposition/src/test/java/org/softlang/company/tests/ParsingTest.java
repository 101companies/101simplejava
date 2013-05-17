package org.softlang.company.tests;

import org.softlang.company.model.*;

import static org.softlang.company.features.Parsing.*;

import java.lang.reflect.Field;
import java.util.LinkedList;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * We do a round-trip test for deserialization.
 * That is, first, we create an object in memory.
 * Then, we read (say, deserialize) the object.
 * Finally, we compare original and read object for structural equality.
 */
public class ParsingTest {

    public static Company createCompany() {

        // Create company
        Company sampleCompany = new Company();
        sampleCompany.setName("ACME Corporation");

        // Create all employees
        Employee craig = new Employee();
        craig.setName("Craig");
        craig.setAddress("Redmond");
        craig.setSalary(123456);
        Employee erik = new Employee();
        erik.setName("Erik");
        erik.setAddress("Utrecht");
        erik.setSalary(12345);
        Employee ralf = new Employee();
        ralf.setName("Ralf");
        ralf.setAddress("Koblenz");
        ralf.setSalary(1234);
        Employee ray = new Employee();
        ray.setName("Ray");
        ray.setAddress("Redmond");
        ray.setSalary(234567);
        Employee klaus = new Employee();
        klaus.setName("Klaus");
        klaus.setAddress("Boston");
        klaus.setSalary(23456);
        Employee karl = new Employee();
        karl.setName("Karl");
        karl.setAddress("Riga");
        karl.setSalary(2345);
        Employee joe = new Employee();
        joe.setName("Joe");
        joe.setAddress("Wifi City");
        joe.setSalary(2344);

        // Create research department
        Department research = new Department();
        research.setManager(craig);
        research.setName("Research");
        research.getEmployees().add(erik);
        research.getEmployees().add(ralf);
        sampleCompany.getDepts().add(research);

        // Create development department
        Department development = new Department();
        development.setManager(ray);
        development.setName("Development");
        sampleCompany.getDepts().add(development);

        // Create sub-department dev1
        Department dev1 = new Department();
        dev1.setName("Dev1");
        dev1.setManager(klaus);
        development.getSubdepts().add(dev1);

        // Create sub-department dev11
        Department dev11 = new Department();
        dev11.setName("Dev1.1");
        dev11.setManager(karl);
        dev11.getEmployees().add(joe);
        dev1.getSubdepts().add(dev11);

        return sampleCompany;
    }

    /*
     * A helper for sanity checking de-/serialization.
     * We test two objects to be structurally equal by means of reflection.
     */
    public static boolean structurallyEqual(Object o1, Object o2) {
        try {
            if (o1.getClass().getName().equals(o2.getClass().getName())) {
			
                for (Class<?> obj = o1.getClass();
                        !obj.equals(Object.class);
                        obj = obj.getSuperclass()) {
                    Field[] f1 = obj.getDeclaredFields();
                    Field[] f2 = obj.getDeclaredFields();

                    for (int i = 0; i < f1.length; i++) {
                        f1[i].setAccessible(true);
                        f2[i].setAccessible(true);
                        // check if fields are primitive types and compare
                        if ((f1[i].getType().isPrimitive()
                                && f2[i].getType().isPrimitive())) {
                            if (!(f1[i].getName().equals(f2[i].getName())))
                                return false;
                            else {
                                if (!(f1[i].get(o1).equals(f2[i].get(o2)))) {
                                    return false;
                                }
                            }
                        // otherwise, they must be objects
                        } else {
                            // to be equal, both can not be null
                            if (f1[i].get(o1) != null && f2[i].get(o2) != null) {
                                // check, if they are of the same class
                                if (f1[i].get(o1).getClass().getName().equals(
                                        f2[i].get(o2).getClass().getName())) {
                                    // check if the class is Double,
                                    // Integer or String
                                    if (check(
                                            f1[i].get(o1).getClass().getName())) {
                                        // compare values
                                        if (!(f1[i].get(o1)
                                                .equals(f2[i].get(o2)))) {
                                            return false;
                                        }
                                    } else {
                                        // special case, if the object is an
                                        // linked list
                                        if (f1[i].get(o1).getClass().getName()
                                                .equals("java.util.LinkedList")) {
                                            if (!(handleLinkedList(
                                                    f1[i],o1, f2[i], o2))) {
                                                return false;
                                            }
                                        } else {
                                        // otherwise, compare the objects
                                            structurallyEqual(f1[i].get(o1),
											                  f2[i].get(o2));
                                        }
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                            // if one of them is null, the objects can not
                            // be equal
                                if (f1[i].get(o1) == null
                                        && f2[i].get(o2) != null) {
                                    return false;
                                }
                                if (f1[i].get(o1) != null
                                        && f2[i].get(o2) == null) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

    // helper helper
    private static boolean check(String s) {
        return (s.equals("java.lang.String") || s.equals("java.lang.Integer")
                || s.equals("java.lang.Double") || s.equals("java.lang.Float"));
    }

    // helper helper
    private static boolean handleLinkedList(Field f1, Object o1, Field f2, Object o2) {
        try {
            LinkedList<?> l1 = (LinkedList<?>) f1.get(o1);
            LinkedList<?> l2 = (LinkedList<?>) f2.get(o2);
            int length = l1.size();
            for (int i = 0; i < length; i++) {
                if (!(structurallyEqual(l1.get(i),l2.get(i)))) {
                    return false;
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Test
    public void testLoadAndCreate() {
        Company sampleCompany = createCompany();
        Company loadedCompany = deserializeCompany("inputs/sampleCompany.ser");
        assertTrue(structurallyEqual(sampleCompany, loadedCompany));
    }

}