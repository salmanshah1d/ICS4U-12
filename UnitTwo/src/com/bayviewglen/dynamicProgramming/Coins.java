package com.bayviewglen.dynamicProgramming;

public class Coins {

	public static void main(String[] args) {
		int n = 24; // coins are 1, 3, 5
		int[] salman = new int[n + 1];
		String str = "";
		for (int i = 0; i < salman.length; i++) {
			salman[i] = -1;
		}
		
		salman[1] = 1;
		salman[3] = 1;
		salman[5] = 1;
		
		for (int i = 1; i <= n; i++) {
			if (salman[i] == -1) {
				if (i - 5 >= 1) {
					salman[i] = 1 + salman[i-5]; 
				} else if (i - 3 >= 1) {
					salman[i] = 1 + salman[i-3];
				} else {
					salman[i] = 1 + salman[i-1];
				}
			}
		}
		
		System.out.println(salman[n]);
		System.out.println(str);
	}
}