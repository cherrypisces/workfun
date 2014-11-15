package com.believe.we.string;

import java.util.HashMap;
import java.util.Hashtable;

import com.believe.we.Utilities;

public class SubstrOfMUniqChars {

	public static String longest(String str, int n) {
		int i = 0;
		int j = 0;
		int K = 0;
		int[] bounds = {0, 0};
		HashMap<Character, Integer> charmap = new HashMap<Character, Integer>();
		
		while (i<str.length()) {
			if (K == n && (j-i)>(bounds[1]-bounds[0])) {
				bounds[0] = i;
				bounds[1] = j;
			}
			
			if (K<=n && j<str.length()) {
				if (!charmap.containsKey(str.charAt(j))) {
					K++;
				}
				charmap.put(str.charAt(j), j);
				j++;
			} else {
				if (charmap.get(str.charAt(i)) == i) {
					K--;
					charmap.remove(str.charAt(i));
				}
				i++;
			}		
		}	
		
		System.out.print("[" + bounds[0] + "," + bounds[1] + "] ");
		return str.substring(bounds[0], bounds[1]);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdeefuiuiwiwwaaaa";
		System.out.println("Original String is: " + s);
		int m = 3;
		System.out.print("Longest substring with " + m +" characters are: ");
		String res = longest(s, m);
		System.out.println(res);
	
		System.out.println(Utilities.randomIntInRange(0, 100000000));
	}

}
