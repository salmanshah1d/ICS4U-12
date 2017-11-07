package com.bayviewglen.dynamicProgramming;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HateYourNeighbor {

	public static void main(String[] args) throws FileNotFoundException {
		readInData();
	}

	private static void readInData() throws FileNotFoundException {
		Scanner input = new Scanner(new FileReader("data/HateYourNeighborTestCases.dat"));

		while (input.hasNext()) {
			int[] arr = new int[Integer.parseInt(input.nextLine().trim())];
			String line = input.nextLine();

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line.split(" ")[i].trim());
			}

			doHateYourNeighbor(arr);
		}
	}

	private static void doHateYourNeighbor(int[] donations) {
		int[] first = new int[donations.length - 1];
		int[] last = new int[donations.length - 1];

		if (donations.length > 2) {
			first[0] = donations[0];
			first[1] = donations[0];

			last[0] = donations[donations.length - 1];
			last[1] = donations[donations.length - 1];

			for (int i = 2; i < donations.length - 1; i++) {
				first[i] = Math.max(first[i - 2] + donations[i], first[i - 1]);
				last[i] = Math.max(last[i - 2] + donations[donations.length - 1 - i], last[i - 1]);
			}

			System.out.println(Math.max(first[first.length - 1], last[last.length - 1]));
		} else {
			System.out.println("The maximum donations is " + Math.max(donations[0], donations[1]) + ".");
		}
	}
}