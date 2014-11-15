package com.believe.we.classloader;

import java.lang.reflect.Proxy;


public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Class Loader of java.lang.String is " + java.lang.String.class.getClassLoader());
		System.out.println("java.ext.dirs path is " + System.getProperty("java.ext.dirs"));
	  	
	
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		System.out.println("Current Context Loader class name is: " + cl.getClass().getName());
		try {
			TestJar instTestJar = (TestJar) (cl.loadClass("com.believe.we.classloader.TestJar").newInstance());
		
			instTestJar.speak("Thread.getContextClassLoader");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class TestJar {
	public void speak(String words)
	{
		System.out.println("Hey, let me say something ...");
		System.out.println(" Hmm, I'm the testing jar package!");
		System.out.println(" Hooray, I'm learning "+ words);
	}
}