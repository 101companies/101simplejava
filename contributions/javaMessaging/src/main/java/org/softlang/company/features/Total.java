package org.softlang.company.features;

import java.util.concurrent.Callable;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * A Callable enables the demonstration of what happens,
 * when there are multiple requesting parties for a 
 * single company and a possibility on how to deal with it.
 * 
 * @author Marcel
 *
 */
public class Total implements Callable<Double>{
	private Connection connection;
	private MessageConsumer consumer;
	private MessageProducer producer;
	private Session session;
	
	public Total(String host, String destination){
		setupConnection(host, destination);
	}

	/**
	 * 
	 * Tell the company thread connected with the queue to compute the total of the company and
	 * return it.
	 * 
	 */
	@Override
	public Double call() throws Exception {
		double result = 0.0;
		try {

			Message message = session.createTextMessage("TOTAL");
			message.setStringProperty("id", "Company");
			producer.send(message);
			message = consumer.receive();
			result = message.getDoubleProperty("result");

		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			session.close();
			connection.close();
		}
		return result;
	}
	
	/**
	 * Setup JMS connection
	 * 
	 * @param host
	 * @param destination
	 */
	private void setupConnection(String host, String destination) {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				host);
		try {
			// Create a Connection
			connection = connectionFactory.createConnection();

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination
			Queue destination2 = session.createQueue(destination);

			// Create MessageConsumer
			consumer = session.createConsumer(destination2,"id='TOTAL-RESULT'");

			// Create MessageProducer
			producer = session.createProducer(destination2);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
