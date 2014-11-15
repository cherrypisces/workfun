package com.believe.we.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	/**
	 * variable argument lists : vararg list
	 * 
	 * Attention: this is an Array syntax!
	 * 
	 * @param holder
	 */
	public static void test (Object...holder) {
		
		for(Object o: holder) {
	//		System.out.println(o.getClass());
			if (o instanceof Integer) {
				System.out.println("Get an Integer: "+ o);
			}
			
			if (o instanceof String) {
				System.out.println("Get an String: "+ o);
			}
		}
		
	}
	
	public static ArrayListTest[] test() {
		List<ArrayListTest> list = new ArrayList<ArrayListTest>();
		
		list.addAll(Arrays.asList(
				new ArrayListTest(),
				new ArrayListTest()
		));
		
		list.addAll(Arrays.asList(ArrayListTest.generator()));
		
		return (ArrayListTest[]) list.toArray();
	}
	
	public static ArrayListTest[] generator() {
		return new ArrayListTest[] {
				new ArrayListTest(),new ArrayListTest(),
		};
	}
	
	public static void main(String[] args) {
		ArrayList<Object> holder = new ArrayList<Object>();		
		holder.add(3);
		holder.add("yes");
		
		System.out.println("Testing ArrayList:");
		test(holder.toArray());
		
		System.out.println("==============================");
		
		Object[] array = new Object[2];
		array[0] = 3;
		array[1] = "yes";
		System.out.println("Testing array:");
		test(array);
				
		System.out.println("===========~~~~~~~~=====");
		generator();
	}
}
