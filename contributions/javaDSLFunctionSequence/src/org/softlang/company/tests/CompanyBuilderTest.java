package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.features.CompanyBuilder;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

/**
 * 
 * @author jan
 *
 * cqCompany means Command & Query company
 * fsCompany means FunctionSequence company
 */
public class CompanyBuilderTest {

	@Test
    public void testCompanyWithDepartments() {
		String name = "abc2";
		
		Company cqCompany = new Company();
		cqCompany.setName(name);
		Department dep1 = new Department();
		dep1.setName("dep1");
		cqCompany.getDepts().add(dep1);
		Department dep2 = new Department();
		dep2.setName("dep2");
		cqCompany.getDepts().add(dep2);
		
		CompanyBuilder builder = new CBCompanyWithDepartments();
		builder.run();
		Company fcCompany = builder.getValue();
		
		assertEquals(cqCompany, fcCompany);
	}
	
	@Test
    public void testSimpleCompany() {
		String name = "abc2";
		
		Company cqCompany = new Company();
		cqCompany.setName(name);
		
		CompanyBuilder builder = new CBSimpleCompany();
		builder.run();
		Company fcCompany = builder.getValue();
		
		assertEquals(cqCompany, fcCompany);
	}
	
    @Test
    public void testBigExample() {
    	CBBigExample builder = new CBBigExample();
    	builder.run();
		Company fcCompany = builder.getValue();
    	
    	Company cqCompany = createCompanyCommandAndQuery();
    	
    	assertEquals(cqCompany, fcCompany);
    }
    
    private Company createCompanyCommandAndQuery() {

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


}