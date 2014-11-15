package com.believe.we.string;

public class MagicNumber {
	
	static final long multiplier = 100000000l;
	
	public static long calConsideration(long closepx, long shares) {
		long orderConsideration = (long) (shares * (((double)closepx) / 100000000));
		return orderConsideration;
	}
	
	public static void main(String[] args) {
	/*	long smallQty_smallPx 	= calConsideration((long)(0.21*10000000L), 1094);
		System.out.println("smallQty_smallPx: " + smallQty_smallPx);
		
		long px = 8680000L * multiplier;
		long smallQty_bigPx 	= calConsideration(px, 1094);
		System.out.println(px + "    smallQty_bigPx: " + smallQty_bigPx);
		
		long bigQty_smallPx 	= calConsideration((long)(0.21*10000000), 5000000000L);
		System.out.println("bigQty_smallPx: " + bigQty_smallPx);
		
		long bigQty_bigPx 		= calConsideration(px, 5000000000L);
		System.out.println("bigQty_bigPx: " + bigQty_bigPx);
		
		px = (long)(0.011*multiplier);
		long examplehk = calConsideration(px, 1121559500L);
		System.out.println("hk: " + examplehk);
		long examplejp = calConsideration((long)(8680000*multiplier), 46200000L);
		System.out.println("jp: " + examplejp);
		long exampleph = calConsideration((long)(0.011*multiplier), 338600000L);
		System.out.println("ph: " + exampleph);
		
		long test = Long.MAX_VALUE;
		System.out.println("Long Max: " + test); 
		
		boolean t = true;
		boolean f = true;
		System.out.println(t ^ f);
		
		long max = Long.MAX_VALUE;
		long min = Long.MIN_VALUE;
		System.out.println(min - max);
		System.out.println(max - min);		

		System.out.println(min + min);
		System.out.println(max + max);
		
		String s = Long.toString(max);
		System.out.println(Double.parseDouble("9223372036854775807"));*/
		
	//	byte test = 'D';
	//	char t 	  = 'D';
		short number = '3' | ('6' << 8);
		System.out.println(number);
		
		assert true !=  false;
	}

}
