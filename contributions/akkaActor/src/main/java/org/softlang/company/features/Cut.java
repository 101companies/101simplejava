package org.softlang.company.features;

import java.util.concurrent.TimeoutException;

import org.softlang.company.actors.CutActor;
import org.softlang.company.messages.CutMessage;
import org.softlang.company.model.Company;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;

public class Cut {
	/**
	 * Cut all salaries from company c
	 * 
	 * @param c
	 */
	public static void cut(Company c) {
		ActorSystem system = ActorSystem.create("MySystem");
		ActorRef myActor = system.actorOf(Props.create(CutActor.class));
		Timeout timeout = new Timeout(Duration.create(10, "seconds"));
		Future<Object> future = Patterns.ask(myActor, new CutMessage(c),
				timeout);// future for getting a result synchronously
		try {
			Await.ready(future, timeout.duration()); // waiting for the future
														// to complete
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		system.shutdown();
	}
}
