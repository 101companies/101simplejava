package org.softlang.company.threads;

import java.util.HashMap;
import java.util.Map;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.softlang.company.model.Company;
import org.softlang.company.model.Department;

public class CompanyManager {

	private Company company;
	private String host;
	private TopicConnection connection;
	private TopicPublisher publisher;
	private TopicSession session;
	private Topic deptTopic;
	private Map<String, Double> deptMap;
	private int counter;

	public CompanyManager(Company company, String host) {
		this.company = company;
		this.host = host;
		setupConnection();
		initialize(company);
	}

	public void cut() {
		try {
			Message msg = session.createTextMessage("Cut");
			publisher.send(msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public double total() {
		counter = 0;
		try {
			Message msg = session.createTextMessage("Total");
			publisher.send(msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		while (counter < deptMap.size())
			System.out.println(counter + "," + deptMap.size());

		int result = 0;
		for (double d : deptMap.values())
			result += d;

		return result;
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
			connection = connectionFactory.createTopicConnection();

			// Create a Session
			session = connection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create the destination
			deptTopic = session.createTopic("Department");

			// Create MessageProducer
			publisher = session.createPublisher(deptTopic);
			publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			Topic totalResultTopic = session.createTopic("Total-Result");
			TopicSubscriber tRsub = session.createSubscriber(totalResultTopic);
			tRsub.setMessageListener(new TotalResultListener(this));

			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shutdown JMS Exception
	 */
	public void shutdown() {
		try {
			publisher.send(session.createTextMessage("Shut down"));
			this.session.close();
			this.connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
		shutdown();
		initialize(company);
	}

	private void initialize(Company company) {
		deptMap = new HashMap<>();
		for (Department d : company.getDepartments()) {
			deptMap.put(d.getName(), 0.0);
			try {
				TopicSubscriber subscr = session.createSubscriber(deptTopic);
				subscr.setMessageListener(new (d, host));
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public String getDestination() {
		return this.company.getName();
	}

	protected synchronized void updateDeptTotal(String n, Double t) {
		counter++;
		deptMap.put(n, t);
	}

}
