package org.softlang.company.threads;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.softlang.company.model.Department;

public class DepartmentListener implements MessageListener {

	private final Department dept;
	private TopicSession session;
	private TopicPublisher publisher;
	private TopicConnection connection;
	private Topic totalResultTopic;

	public DepartmentListener(Department d, String host) {
		dept = d;
		setupConnection(host);
	}

	@Override
	public void onMessage(Message msg) {
		try {
			if (((TextMessage) msg).getText().equals("Cut"))
				dept.cut();
			if (((TextMessage) msg).getText().equals("Total")){
				double total = dept.total();
				Message totalmsg = session.createMessage();
				totalmsg.setStringProperty("name", dept.getName());
				totalmsg.setDoubleProperty("total", total);
				publisher.send(totalmsg);
			}
			if (((TextMessage) msg).getText().equals("Shut down")){
				shutdown();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private void setupConnection(String host) {
		// Create a ConnectionFactory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				host);
		try {
			// Create a Connection
			connection = connectionFactory.createTopicConnection();

			// Create a Session
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination
			totalResultTopic = session.createTopic("Total-Result");

			// Create MessageProducer
			publisher = session.createPublisher(totalResultTopic);
			publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		try {
			this.session.close();
			this.connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
