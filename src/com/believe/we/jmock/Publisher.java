package com.believe.we.jmock;

import java.util.ArrayList;

public class Publisher {
	
	private ArrayList<Subscriber> subscribers;
	
	public Publisher() 
	{
		subscribers = new ArrayList<Subscriber>();
	}
	
	public void add(Subscriber subscriber)
	{
		if (subscriber == null)
			return;
		
		subscribers.add(subscriber);
	}
	
	public void publish(String message)
	{
		for(Subscriber subscriber : subscribers)
		{
			subscriber.receive(message);
		}
		
	}
}
