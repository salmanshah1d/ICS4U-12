package com.bayviewglen.arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestGrader {

	public static void main(String[] args) {
		String[][] arr = new String[8][10];
		String[] correct = {"D","B","D","C","C","D","A","E","A","D"};
		int[] grades = new int[8];
		read(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j].equals(correct[j])) {
					grades[i] += 1;
				}
			}
		}
		
		for (int k = 0; k < grades.length; k++) {
			System.out.println("Student " + (k + 1) + "'s score is " + grades[k] + ".");
		}
	}

	private static void read(String[][] arr) {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("data/grades.dat"));
			
			// One way of reading the file
			for (int j = 0; j < 8; j++) {
				String contentLine = br.readLine();
				for (int i = 0; i < 10; i++) {
					arr[j][i] = contentLine.substring(i, i+1);
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				
			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
			}

		}
	}
}