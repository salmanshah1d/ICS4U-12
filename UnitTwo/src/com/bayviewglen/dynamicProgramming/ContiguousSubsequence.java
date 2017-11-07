package com.bayviewglen.dynamicProgramming;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ContiguousSubsequence {
	public static void main(String[] args) throws FileNotFoundException {
		readInData();
	}

	private static void readInData() throws FileNotFoundException {
		Scanner input = new Scanner(new FileReader("data/ContiguousSubsequenceTestCases.dat"));

		while (input.hasNext()) { 
			int[] arr = new int[Integer.parseInt(input.nextLine().trim())];
			String line = input.nextLine();
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line.split(" ")[i].trim());
			}
			
			doContiguousSubsequence(arr);
		}
	}

	private static void doContiguousSubsequence(int[] input) {
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