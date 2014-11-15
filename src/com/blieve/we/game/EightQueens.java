package com.blieve.we.game;

public class EightQueens {
	protected static int[] columnAtRow = new int[8];
	
	public static boolean check(int row) {
		for(int i=0; i<row; i++) {
			int diff = Math.abs(columnAtRow[i]-columnAtRow[row]);
			if (diff == 0 || diff == (row-i))
				return false;
		}
		return true;
	}
	
	public static void printBoard() {
		System.out.println("\n\n ---------------------------------");
		for(int i=0; i<8; i++) {
			System.out.print(" |");
			for(int j=0; j<8; j++) {
				if (j == columnAtRow[i]) 
					System.out.print(" Q |");
				else
					System.out.print("   |");
			}
			System.out.println();
			System.out.println(" ---------------------------------");
		}
	}
	
	public static void placeRow(int row) {
		if (row == 8) {
			printBoard();
			return;
		}
		
		for(int i=0;i<8; i++) {
			columnAtRow[row] = i;
			if(check(row))
				placeRow(row+1);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeRow(0);
	}

}
