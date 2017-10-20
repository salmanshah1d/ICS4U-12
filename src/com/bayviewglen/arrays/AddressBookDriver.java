package com.bayviewglen.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bayviewglen.trees.BST;

public class AddressBookDriver {

	public static void main(String[] args) throws IOException {
		AddressBook contacts = new AddressBook(); // instantiates the BST
		contacts.populate(); // reads in previous contacts
		boolean demo = true;
		String option;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to Contacts.");

		while (demo) { // loop that closes the program and saves the BST to a .dat file when the user quits
			option = printMenu();

			if (option.equals("1")) { // adds contact
				contacts.add();

			} else if (option.equals("2")) { // displays contacts
				contacts.display();
				
			} else if (option.equals("3")) { // searches contacts
				contacts.search();

			} else if (option.equals("4")) { // deletes contacts
				contacts.delete();
				
			} else if (option.equals("5")) { // quits app
				demo = false;
				contacts.save();
			}
		}
		System.out.print("Thank you. Come again.");
	}

	private static String textCheck(String input) { // checks valid input
		Scanner keyboard = new Scanner(System.in);
		while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")
				|| input.equals("5"))) {
			System.out.print("Please choose 1, 2, 3, 4, or 5.");
			input = keyboard.nextLine();
		}
		return input;
	}
	
	private static String printMenu() { // prints options
		Scanner keyboard = new Scanner(System.in);
		System.out.println("");
		System.out.println("1: Add Contact");
		System.out.println("2: Display Contacts ");
		System.out.println("3: Search");
		System.out.println("4: Delete Contact");
		System.out.println("5: Exit");
		System.out.println();
		System.out.print("Enter one of the options above: ");
		return textCheck(keyboard.nextLine());
	}
}