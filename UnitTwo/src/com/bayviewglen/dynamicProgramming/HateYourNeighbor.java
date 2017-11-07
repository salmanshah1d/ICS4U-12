package com.bayviewglen.dynamicProgramming;

public class HateYourNeighbor {

	public static void main(String[] args) {
		int[] donations = {10, 2, 3, 18, 70, 90, 100}; // 173
		// int[] donations = {10, 2, 3, 18, 2}; // 28
		int[] result = new int[donations.length-1];
		
		if (donations.length > 2) {
			result[0] = donations[0];
			result[1] = donations[1];
			
			for (int i = 1; i < donations.length - 2; i++) {
				if (i+2 != donations.length-1 && donations[i+1] < donations[i+2]) {
					first[i] = first[i-1] + donations[i+1]; 
				} else {
					first[i] = first[i-1] + donations[i+2];
				}
				
				if (donations[i] > donations[i+1]) {
					last[i] = last[i-1] + donations[i]; 
				} else {
					last[i] = last[i-1] + donations[i+1];
				}
			}
			System.out.println(Math.max(first[donations.length - 3], last[donations.length - 2]));
		} else {
			System.out.println(Math.max(first[0], last[1]));
		}
	}
}