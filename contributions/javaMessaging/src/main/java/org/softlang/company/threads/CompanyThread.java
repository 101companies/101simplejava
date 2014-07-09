package org.softlang.company.threads;

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
import org.softlang.company.model.Company;

public class CompanyThread implements Runnable {
	private Company company;
	private String host;
	private Connection connection;
	private MessageConsumer consumer;
	private MessageProducer producer;
	private Session session;
	private boolean loop = true;

	public CompanyThread(Company company, String host) {
		this.company = company;
		this.host = host;
		setupConnection();
	}

	/**
	 * Setup JMS connection
	 * 
	 * 
	 */
	private void setupConnection() {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				this.host);
		try {
			// Create a Connection
			connection = connectionFactory.createConnection();

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination
			Destination destination = session.createQueue(this.company
					.getName());

			// Create MessageConsumer
			consumer = session.createConsumer(destination);

			// Create MessageProducer
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {

			loop = true;
			Message message;

			do {
				// Receive message
				message = consumer.receive(1000);
				if (message instanceof TextMessage) {
					String text = ((TextMessage) message).getText();
					if (text.equals("TOTAL")) {
						// Create answer-message and send it
						message = session.createTextMessage("TOTAL-RESULT");
						message.setDoubleProperty("result", company.total());
						producer.send(message);

					}

					if (text.equals("CUT")) {
						// Create answer-message and send it
						company.cut();
						message = session.createTextMessage("CUT-COMPLETE");
						producer.send(message);
					}

					if (text.equals("SHUTDOWN")) {
						// Create answer-message and send it
						message = session.createTextMessage("OK-SHUTDOWN");
						producer.send(message);
						loop = false;
					}

				}
			} while (loop);

			// Clean up
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shutdown JMS Exception
	 */
	public void shutdown() {
		try {
			loop = false;
			this.session.close();
			this.connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getDestination() {
		return this.company.getName();
	}

}
