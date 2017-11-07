package com.bayviewglen.dynamicProgramming;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ZigZag {

	public static void main(String[] args) throws FileNotFoundException {
		readInData();
	}

	private static void readInData() throws FileNotFoundException {
		Scanner input = new Scanner(new FileReader("data/ZigZagTestCases.dat"));

		while (input.hasNext()) { 
			int[] arr = new int[Integer.parseInt(input.nextLine().trim())];
			String line = input.nextLine();
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line.split(" ")[i].trim());
			}
			
			doZigZag(arr);
		}
	}

	private static void doZigZag(int[] arr) {	
		int[] incr = new int[arr.length];
		int[] decr = new int[arr.length];

		incr[0] = 1;
		decr[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				incr[i] = decr[i - 1] + 1;
				decr[i] = decr[i - 1];
			} else if (arr[i - 1] == arr[i]) {
				incr[i] = incr[i - 1];
				decr[i] = decr[i - 1];
			} else {
				decr[i] = incr[i - 1] + 1;
				incr[i] = incr[i - 1];
			}
		}

		System.out.println("The length of the longest subsequence is "
				+ Math.max(incr[arr.length - 1], decr[arr.length - 1]) + ".");
	}
}