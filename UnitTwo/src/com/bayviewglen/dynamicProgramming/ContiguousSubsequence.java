package com.bayviewglen.dynamicProgramming;

public class ContiguousSubsequence {
	public static void main(String[] args) {
		int[] input = {10, -5, 40, 10, 10, 15, -30};
		int[] output = new int[input.length];
		int max = 0;
		output[0] = input[0];
		
		for (int i = 1; i < output.length; i++) {
			if (output[i-1] + input[i] < input[i]) {
				output[i] = input[i];
			} else {
				output[i] = output[i-1] + input[i];
				if (output[max] < output[i]) {
					max = i;
				}
			}
		}
		
		System.out.println("The max sum of a contiguous subsequence is " + output[max] + ".");
	}
}