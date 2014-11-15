package com.believe.we.string;

public class ReflectionTest {

	class A implements TestInterface {
		public A () {
			System.out.println("Creating A");
		}
		
		public void ack() {
			System.out.println("A");
		}
	}
	
	class B extends A {		
		public B () {
			System.out.println("Creating B");
		}
	
		public void ack() {
			System.out.println("B");
		}
	}
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        try {
        	Class<?> cls = B.class;
			System.out.println(cls.getInterfaces().length);
        	for (Class <?> c : cls.getInterfaces()) {
        			System.out.println(c.equals(TestInterface.class));
        		    if(c.equals(TestInterface.class)) {
		        		A a = (A)cls.newInstance();
		        		a.ack();
		        		break;
        		    }
        	}
        } catch (Exception e) {
        	
        }
		System.out.println("out of try-catch");
	}
	
	public static void test () {
		
		String className = "com.believe.test.Hello";			
		try {
			Class<?> cls = Class.forName(className);
			System.out.println("after find class");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find " + className);
			throw new RuntimeException("here");
		}
	}

}
