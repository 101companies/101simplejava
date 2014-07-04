package org.softlang.company.actors;

import java.util.ArrayList;
import java.util.List;

import org.softlang.company.messages.DepartmentsMessage;
import org.softlang.company.messages.EmployeeMessage;
import org.softlang.company.messages.EndMessage;
import org.softlang.company.model.Department;
import org.softlang.company.model.Employee;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class DepartmentsActor extends UntypedActor {
	private ActorRef back = null;
	private boolean end = false;

	@Override
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		if (message instanceof DepartmentsMessage) {
			back = this.getSender();
			List<Employee> employees = this
					.getEmployees(((DepartmentsMessage) message)
							.getDepartments());
			back.tell(new EmployeeMessage(employees), this.getSelf());
			if (end) {
				back.tell(new EndMessage(), this.getSelf());
			}
		} else if (message instanceof EndMessage)
			back.tell(message, this.sender());
		else {
			unhandled(message);
		}
	}

	/**
	 * collect employees from departments ds
	 * 
	 * @param ds
	 * @return collected employees
	 */
	private List<Employee> getEmployees(List<Department> ds) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		List<Department> nextDepartments = new ArrayList<Department>();
		for (Department d : ds) {
			nextDepartments.addAll(d.getDepartments());
		}
		nextInstance(nextDepartments);
		for (Department d : ds) {
			if (d.getManager() != null)
				employees.add(d.getManager());
			employees.addAll(d.getEmployees());
		}
		return employees;
	}

	/**
	 * Create next instance if departments available
	 * 
	 * @param nextDepartments
	 */
	private void nextInstance(List<Department> nextDepartments) {
		if (!nextDepartments.isEmpty()) {
			ActorRef child = this.context().actorOf(
					Props.create(DepartmentsActor.class));
			child.tell(new DepartmentsMessage(nextDepartments), this.back);
		} else {
			end = true;
		}
	}
}
