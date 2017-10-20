package com.bayviewglen.arrays;

public class ForEachTester {

	public static void main(String[] args) {
		char[][] words = new char [3][];
		
		words [0] = "cipher".toCharArray();
		words [1] = "hiccup".toCharArray();
		words [2] = "laughable".toCharArray();
		
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length; j++) {
				words[i][j] += 2;
			}
		}
		
		for (char[] arr : words) {
			for (char letter : arr) {
				System.out.print(letter);
			}
			System.out.println();
		}
	}
}