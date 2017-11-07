package com.bayviewglen.dynamicProgramming;

public class HateYourNeighbor {

	public static void main(String[] args) {
		int[] donations = {10, 2, 3, 18, 70, 90, 100}; // 173
		//int[] donations = {10, 2, 3, 18, 2}; // 28
		int[] first = new int[donations.length-1];
		int[] last = new int[donations.length-1];
		
		if (donations.length > 2) {
			first[0] = donations[0];
			first[1] = donations[0];
			
			last[0] = donations[donations.length-1];
			last[1] = donations[donations.length-1];
			
			for (int i = 2; i < donations.length - 1; i++) {
				first[i] = Math.max(first[i-2] + donations[i], first[i-1]);
				last[i] = Math.max(last[i-2] + donations[donations.length - 1 - i], last[i-1]);
			}
			
			System.out.println(Math.max(first[first.length - 1], last[last.length - 1]));
		} else {
			System.out.println(Math.max(donations[0], donations[1]));
		}
	}
}