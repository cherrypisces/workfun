package com.believe.we.bitmanipulation;

import java.util.Random;

public class BitVector {
	public static final int SIZE = 1000000;
	public static final int SHIFT = 5;
	public static final int MASK = 0x1F;
	public int[] array = new int[SIZE];

	public void set(int n) {
		array[n>>SHIFT] |= (1<<(n & MASK));
	}
	
	public void cls(int n) {
		array[n>>SHIFT] &= ~(1<<(n & MASK));
	}
	
	public boolean test(int n) {
		int res = array[n>>SHIFT] & (1<<(n & MASK));
		return res == 0 ? false:true;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder();
		for(int i=0; i<SIZE;i++) {
			if (test(i)) {
				res.append("a["+i+"] ");
			}
		}
		res.append("\n");
		return res.toString();
	}
	
	public static void testFunc_1() {
		
		BitVector bv = new BitVector();
		Random randomGen = new Random();
		int times = randomGen.nextInt(20);
		System.out.println("Will generate " + times + " numbers ...");
		for(int i=0; i<times;i++) {
			int number = randomGen.nextInt(BitVector.SIZE);
			System.out.println("Setting number " + number + " ...");
			bv.set(number);
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("After setting, the array looks like...");
		System.out.println(bv);
		
		times = randomGen.nextInt(10);
		System.out.println("Will clear " + times + " numbers ...");
		for(int i=0; i<times;i++) {
			int number;
			do {
				number = randomGen.nextInt(BitVector.SIZE);
			} while (!bv.test(number));
			System.out.println("Clearing number " + number + " ...");
			bv.cls(number);
		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("After clearing, the array looks like...");
		System.out.println(bv);
	}
	
	public static void testFunc_2() {
		BitVector bv = new BitVector();
//		Random randomGen = new Random();
//		int number = randomGen.nextInt(BitVector.SIZE);
		int number = 1992;
		System.out.println("Simulating bit manipulation on " + number + " ...");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("n & MASK = " + (number & MASK));
		System.out.println("1 << (n & MASK) = " + (1<<(number & MASK)));
		System.out.println("n >> SHIFT = " + (number >> SHIFT)); 
		bv.set(number);
		System.out.println("array[" + number + "] = " + bv.array[number>>SHIFT] );
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println("value of MASK(0x1F) is : " + BitVector.MASK);
	//	BitVector.testFunc_1();
		Class cls = BitVector.class;
		try {
			BitVector bVector = (BitVector)(cls.newInstance());
			System.out.println(bVector.array.length);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
