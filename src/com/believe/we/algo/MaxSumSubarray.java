package com.believe.we.algo;

import com.believe.we.Utilities;

public class MaxSumSubarray {
	
	public static int maxSumSubArray(int[] array) {
		if (array == null)
			return 0;
		
		int sum = 0;
		int max = array[0];
		for(int i=0; i<array.length; i++) {
			if(sum < 0)
				sum = array[i];
			else 
				sum += array[i];
			
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = Utilities.randomArray(10, -5, 5);
		System.out.println("The array is: ");
		Utilities.printArray(array);
		System.out.println("The max continuous sum is: " + maxSumSubArray(array));
		
	}

}
