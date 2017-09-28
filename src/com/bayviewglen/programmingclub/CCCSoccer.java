package com.bayviewglen.programmingclub;

public class CCCSoccer {

	public static void main(String[] args) {
		//n!/(r!(n-r)!)
		
		int n = 89;
		int r = 3;
		
		long num1 = 1;
		long num2 = 6;
		long num3 = 1;
		
		System.out.println(num1*n);
		
		for (int i = 1; i < 89; i++) {
			num1 *= i;
		}
		
		for (int j = (n - r); j > 1; j--) {
			num3 *= j;
		}
	}
}