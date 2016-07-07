package org.softlang.company.threads;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class TotalResultListener implements MessageListener{

    private CompanyManager manager;

	public TotalResultListener(CompanyManager cm) {
		this.manager = cm;
	}
	
	@Override
	public void onMessage(Message msg) {
		try {
			manager.updateDeptTotal(msg.getStringProperty("name"), msg.getDoubleProperty("total"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
