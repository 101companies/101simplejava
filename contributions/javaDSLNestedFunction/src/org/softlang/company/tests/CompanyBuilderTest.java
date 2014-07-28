package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.CompanyBuilder.*;

import org.junit.Test;
import org.softlang.company.features.CompanyBuilder;
import org.softlang.company.features.tokens.AddressToken;
import org.softlang.company.features.tokens.ManagerToken;
import org.softlang.company.features.tokens.NameToken;
import org.softlang.company.features.tokens.SalaryToken;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

/**
 * 
 * @author jan
 *
 * cqCompany means Command & Query company
 * nfCompany means NestedFunction company
 */
public class CompanyBuilderTest {

	@Test
    public void testCompanyWithOneDepartment() {
		String name = "abc2";
		
		Company cqCompany = new Company();
		cqCompany.setName(name);
		Department dep = new Department();
		cqCompany.getDepts().add(dep);
		
		Company mcCompany = CompanyBuilder
				.company(
					name(name),
					dep
				);
		assertEquals(cqCompany, mcCompany);
	}
	
	@Test
    public void testCompanyWithDepartments() {
		String name = "abc2";
		
		Company cqCompany = new Company();
		cqCompany.setName(name);
		Department dep = new Department();
		cqCompany.getDepts().add(dep);
		Department dep2 = new Department();
		cqCompany.getDepts().add(dep);
		Department dep3 = new Department();
		cqCompany.getDepts().add(dep);
		
		Company mcCompany = CompanyBuilder
				.company(
					name(name),
					dep,
					dep2,
					dep3
				);
		assertEquals(cqCompany, mcCompany);
	}
	
	@Test
    public void testCompany() {
		String name = "abc2";
		
		Company cqCompany = new Company();
		cqCompany.setName(name);
		
		Company mcCompany = CompanyBuilder
				.company(name(name));
		assertEquals(cqCompany, mcCompany);
	}
	
    @Test
    public void testBigExample() {
    	Company nfCompany = createCompanyNestedFunction();
    	Company cqCompany = createCompanyCommandAndQuery();
    	assertEquals(cqCompany, nfCompany);
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

    public static Company createCompanyNestedFunction(){
		return 
		company(
			name("ACME Corporation"),
			department(
				name("Research"),
				manager(
					name("Craig"),
					address("Redmond"),
					salary(123456)
				),
				employees(
					employee(
						name("Erik"),
						address("Utrecht"),
						salary(12345)
					),
					employee(
						name("Ralf"),
						address("Koblenz"),
						salary(1234)
					)
				)
			),		
			department(
				name("Development"),
				manager(
					name("Ray"),
					address("Redmond"),
					salary(234567)
				),
				employees(),
				department(
					name("Dev1"),
					manager(
						name("Klaus"),
						address("Boston"),
						salary(23456)
					),
					employees(),
					department(
						name("Dev1.1"),
						manager(
							name("Karl"),
							address("Riga"),
							salary(2345)
						),
						employees(
							employee(
								name("Joe"),
								address("Wifi City"),
								salary(2344)
							)
						)
					)
				)
			)
		);
	}

}