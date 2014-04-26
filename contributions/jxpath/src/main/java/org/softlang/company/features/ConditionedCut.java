package org.softlang.company.features;

import java.util.ArrayList;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.softlang.company.model.Company;
import org.softlang.company.model.Employee;

/**
 * To demonstrate JXPath ability to select certain nodes and values
 * 
 * @author Matthias Paul
 * 
 */
public class ConditionedCut {

	/**
	 * 
	 * @param c
	 *            Company to cut salary
	 * @param condition
	 *            condition for cutting salary. The condition works on the
	 *            Employee attributes salary, name and address. Use <a
	 *            href="http://www.w3schools.com/xpath/xpath_operators.asp"
	 *            >w3schools-operators</a> and <a
	 *            href="http://www.w3schools.com/xpath/xpath_examples.asp"
	 *            >w3schools-examples</a> as reference. Example:
	 *            "salary>2000 and name!='Koblenz'"
	 * 
	 * @exception JXPathInvalidSyntaxException
	 *                if condition is empty or is only whitespace
	 * 
	 */
	public static void conditionedCut(Company c, String condition)
			throws JXPathInvalidSyntaxException {
		JXPathContext con = JXPathContext.newContext(c);
		ArrayList<Employee> es = new ArrayList<Employee>();
		es.addAll(con.selectNodes("//employees[" + condition + "]"));
		es.addAll(con.selectNodes("//manager[" + condition + "]"));
		// for (Employee e : es)
		// e.setSalary(e.getSalary() / 2);
		con = JXPathContext.newContext(es);
		for (int i = 1; i <= es.size(); i++) {
			con.setValue("@salary[" + i + "]",
					(Double) con.getValue("@salary[" + i + "]") / 2);
		}
	}

}
