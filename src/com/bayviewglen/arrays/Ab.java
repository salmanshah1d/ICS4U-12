package com.bayviewglen.arrays;

import java.util.Scanner;

public class Ab {

	public static void main(String[] args) {
		String option;
		printMen();
		System.out.println(option);
	}

	private void printMen() {
		// TODO Auto-generated method stub
		
	}

	private String printMenu() { // prints options
		Scanner keyboard = new Scanner(System.in);
		System.out.println("");
		System.out.println("1: Add Contact");
		System.out.println("2: Display Contacts ");
		System.out.println("3: Search");
		System.out.println("4: Delete Contact");
		System.out.println("5: Exit");
		System.out.println();
		System.out.print("Enter one of the options above: ");
		return (keyboard.nextLine());
	}
	
	private String textCheck(String input) { // checks valid input
		Scanner keyboard = new Scanner(System.in);
		while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")
				|| input.equals("5"))) {
			System.out.print("Please choose 1, 2, 3, 4, or 5.");
			input = keyboard.nextLine();
		}
		return input;
	}
}