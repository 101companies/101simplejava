package org.softlang.company.features;

import org.softlang.company.actors.TotalActor;
import org.softlang.company.messages.TotalMessage;
import org.softlang.company.model.Company;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;

public class Total {

	/**
	 * get total of all salaries from company c
	 * 
	 * @param c
	 * @return total from company c
	 */
	public static double total(Company c) {
		double result = 0.0;
		ActorSystem system = ActorSystem.create("MySystem");
		ActorRef myActor = system.actorOf(Props.create(TotalActor.class));
		Timeout timeout = new Timeout(Duration.create(10, "seconds"));
		Future<Object> future = Patterns.ask(myActor, new TotalMessage(c),
				timeout);// future for getting a result synchronously
		try {
			result = (Double) Await.result(future, timeout.duration());
			// waiting for the future
			// to complete and getting its value
		} catch (Exception e) {
			e.printStackTrace();
		}
		system.shutdown();
		return result;
	}

}
