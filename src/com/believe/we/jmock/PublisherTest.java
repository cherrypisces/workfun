package com.believe.we.jmock;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class PublisherTest {
	Mockery context = new JUnit4Mockery();

	@Test
	public void oneSubscriberReceviesAMessage() {
		final Subscriber subscriber = context.mock(Subscriber.class);
		
		Publisher publisher = new Publisher();
		publisher.add(subscriber);
		
		final String message = "message";
		
		context.checking(new Expectations() {{
			oneOf (subscriber).receive(message); 
		}});
		
		publisher.publish(message);
	
	}
}
