package com.believe.we.annotation;

import java.lang.reflect.Method;

@Developer("Rochelle Yin")
public class TestAnnotation {
	
	@MyHints(author="YINR", priority=MyHints.Priority.HIGH, status=MyHints.Status.STARTED)
	public static void main(String[] args) {
		
		Class clz = TestAnnotation.class;
		Developer dev = (Developer) clz.getAnnotation(Developer.class);
		if (dev != null) {
			System.out.println("Developer: " + dev.value() +"\n");
		}
		
		for(Method method : clz.getMethods()) {
			MyHints hints = method.getAnnotation(MyHints.class);
			
			if (hints != null) {
				System.out.println("Method name: " + method.getName());
				System.out.println("Author: " + hints.author());
				System.out.println("Priority: " + hints.priority());
				System.out.println("Status: " + hints.status());
			}
			
		}
	}

}
