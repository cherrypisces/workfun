package com.believe.we;

import java.util.Random;



public class Utilities {
	
	public static int randomIntInRange(int min, int max) {
		if (min > max) {
			return 0;
		} else {
			Random rand = new Random();
			return min + rand.nextInt(max-min+1);
		}
	}
	
	public static int[] randomArray(int N, int min, int max) {
		int[] array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = randomIntInRange(min, max);
		}
		return array;
	}
	
	public static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(" " + array[i]);
		}
		System.out.println();
	}
}
