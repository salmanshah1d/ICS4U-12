package com.bayviewglen.dynamicProgramming;

public class ContiguousSubsequence {
	public static void main(String[] args) {
		int[] input = {10, 9, 43, -54, 65, -87, -90, 23, 10000};
		int[] output = new int[input.length];
		String[] path = new String[input.length];
		
		int max = 0;
		output[0] = input[0];
		path[0] = input[0] + "";
		
		for (int i = 1; i < output.length; i++) {
			if (output[i-1] + input[i] < input[i]) {
				output[i] = input[i];
				path[i] = input[i] + "";
				
				if (output[max] < output[i]) {
					max = i;
				}
			} else {
				output[i] = output[i-1] + input[i];
				path[i] = path[i-1] + ", " + input[i];
				if (output[max] < output[i]) {
					max = i;
				}
			}
		}
		
		System.out.println("The contiguous subsequence with the largest sum is " + path[max] + " (with a sum of " + output[max] + ").");
	}
}