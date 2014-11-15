package com.blieve.we.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marin {

	public enum TestEnum {
		v1,
		v2,
		v3
	}
	
	public static void main(String[] args) {
		// b. convert array to list
		Integer[] array = new Integer[] {3,2,7};
		long[] array2 = new long[] {5, 4, 7};
		// a. how to sort array
	//	Arrays.sort(array);
		List<Integer> list = Arrays.asList(array);
		//List list2 = Arrays.asList(array2);
	//	List list2 = new ArrayList<>(array);
		for(Object i : list) {
			System.out.println(i);
		}
		
		// c. Generics are checked at compiler-time		
		
		// d. convert string into Enum
		// Whenever an ENUM is complied in Java, two static methods are added by compiler 
		// called valueOf() and values(). 
		// We can use valueOf() method to convert any String value to ENUM.
		TestEnum t = TestEnum.valueOf("v2");
		System.out.println(t);
		
		// e. time efficiency : insert N strings into TreeSet  O(NlgN)
		// f. time efficiency : insert N strings into HashSet  O(N)		
	}
	
	
	
	

}
