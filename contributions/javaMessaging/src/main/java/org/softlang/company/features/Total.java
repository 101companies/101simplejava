package org.softlang.company.features;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Total {
	private static Connection connection;
	private static MessageConsumer consumer;
	private static MessageProducer producer;
	private static Session session;
	private static boolean loop;

	/**
	 * get total of all salaries from company at destination
	 * 
	 * @param destination
	 *            destination of the CompanyThread
	 * @return total from company at destination
	 */
	public static double total(String destination, String host) {
		setupConnection(host, destination);

		double result = 0.0;
		try {

			Message message = session.createTextMessage("TOTAL");
			producer.send(message);

			loop = true;

			while (loop) {
				message = consumer.receive(1000);
				String s;
				if (message instanceof TextMessage) {

					s = ((TextMessage) message).getText();
					if (s.equals("TOTAL-RESULT")) {
						result = message.getDoubleProperty("result");
						loop = false;
					}

				}

			}

			// Clean up
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * Setup JMS connection
	 * 
	 * @param host
	 * @param destination
	 */
	private static void setupConnection(String host, String destination) {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				host);
		try {
			// Create a Connection
			connection = connectionFactory.createConnection();

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination
			Destination destination2 = session.createQueue(destination);

			// Create MessageConsumer
			consumer = session.createConsumer(destination2);

			// Create MessageProducer
			producer = session.createProducer(destination2);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
