package org.softlang.company.features;

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
 * A runnable enables the demonstration of what happens,
 * when there are multiple sending parties for a 
 * single queue and a possibility on how to deal with it.
 * 
 * @author Marcel
 *
 */
public class Cut implements Runnable {
	private Connection connection;
	private MessageConsumer consumer;
	private MessageProducer producer;
	private Session session;
	private Queue queue;

	public Cut(String host,String destination){
		setupConnection(host, destination);
	}
	
	/**
	 * send a message to the queue in order to tell it
	 * to execute the cut operation on the saved company.
	 * 
	 * @param destination
	 *            destination of the company to cut
	 * @param host
	 *            host url to connect to
	 */
	public void run() {
		try {
			Message msg = session.createTextMessage("CUT");
			msg.setStringProperty("id", "Company");
			producer.send(msg);

			msg = consumer.receive(1000);
			
			// Clean up
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
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
			queue = session.createQueue(destination);

			// Create MessageConsumer
			consumer = session.createConsumer(queue,"id='CUT-COMPLETE'");

			// Create MessageProducer
			producer = session.createProducer(queue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
