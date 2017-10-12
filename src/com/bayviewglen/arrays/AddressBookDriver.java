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
		BST contacts = new BST(); // instantiates the BST
		populate(contacts); // reads in previous contacts
		boolean demo = true;
		String option, first, last, number; 
		Scanner keyboard = new Scanner(System.in);
		Contact newContact;

		System.out.println("Welcome to Contacts.");

		while (demo) { // loop that closes the program and saves the BST to a .dat file when the user quits
			option = printMenu();

			if (option.equals("1")) { // adds contact

				System.out.print("Enter first name: ");
				first = alpha(keyboard.nextLine(), 1);
				System.out.print("Enter last name: ");
				last = alpha(keyboard.nextLine(), 2);

				if (contacts.ifExists(first, last)) { // checks if contact already exists then implements accordingly
					System.out.println("This contact already exists.");
				} else {
					System.out.print("Enter phone number: ");
					number = numeric((keyboard.nextLine()));
					newContact = new Contact(first, last, number);
					contacts.add(newContact);
					System.out.println(newContact.toString2() + " has been added.");
				}

			} else if (option.equals("2")) { // displays contacts
				if (contacts.getRoot() == null) {
					System.out.println("You don't have any contacts.");
				} else {
					contacts.inOrderTraversal(contacts.getRoot());
				}
				
			} else if (option.equals("3")) { // searches contacts
				if (contacts.getRoot() == null) {
					System.out.println("You don't have any contacts.");
				} else {
					System.out.print("Enter first name: ");
					first = alpha(keyboard.nextLine(), 1);
					System.out.print("Enter last name: ");
					last = alpha(keyboard.nextLine(), 2);
					System.out.println(contacts.search(first, last));
				}

			} else if (option.equals("4")) { // deletes contacts
				if (contacts.getRoot() == null) {
					System.out.println("You don't have any contacts.");
				} else {
					System.out.print("Enter first name: ");
					first = alpha(keyboard.nextLine(), 1);
					System.out.print("Enter last name: ");
					last = alpha(keyboard.nextLine(), 2);
					boolean done = contacts.delete(first, last);
					if (done) {
						System.out.println(first + " " + last + " has been deleted.");
					} else {
						System.out.println(first + " " + last + " is not in your contact list.");
					}
				}
			} else if (option.equals("5")) { // quits app
				demo = false;
				save(contacts);
			}
		}
		System.out.print("Thank you. Come again.");
	}

	private static void populate(BST contacts) { // reads in from .dat file

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("data/contacts.dat"));
			String first, last, number;

			// One way of reading the file
			String contentLine = br.readLine();

			while (contentLine != null) {
				first = contentLine.split(" ")[0].trim();
				last = contentLine.split(" ")[1].trim();
				number = contentLine.split(" ")[2].trim();
				contacts.add(new Contact(first, last, number));
				contentLine = br.readLine();
			}

		} catch (IOException ioe) {
			// does nothing so that if there's no input file it just assumes an empty BST
		} finally {
			try {
				if (br != null)
					br.close();

			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
			}

		}
	}

	private static void save(BST contacts) throws IOException { // saves to .dat file
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/contacts.dat"));
		if (contacts.getRoot() != null) {
			contacts.save(contacts.getRoot(), writer);
		}
		writer.close();
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

	private static String textCheck(String input) { // checks valid input
		Scanner keyboard = new Scanner(System.in);
		while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")
				|| input.equals("5"))) {
			System.out.print("Please choose 1, 2, 3, 4, or 5.");
			input = keyboard.nextLine();
		}

		return input;
	}

	private static String alpha(String input, int num) { // checks valid alphabet input
		Scanner keyboard = new Scanner(System.in);
		String message;
		boolean valid = true;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		if (num == 1) {
			message = "Please enter first name: ";
		} else {
			message = "Please enter last name: ";
		}

		for (int i = 0; i < input.length() && valid == true; i++) {
			if (alphabet.indexOf(input.substring(i, i + 1)) == -1) {
				valid = false;
			}
		}

		while (valid == false) {
			valid = true;
			System.out.print(message);
			input = keyboard.nextLine();

			for (int i = 0; i < input.length() && valid == true; i++) {
				if (alphabet.indexOf(input.substring(i, i + 1)) == -1) {
					valid = false;
				}
			}
		}

		return input;
	}

	private static String numeric(String input) { // checks valid numerical (string) input
		final int NUM_LENGTH = 10;
		Scanner keyboard = new Scanner(System.in);
		boolean valid = true;
		String numbers = "0123456789";

		for (int i = 0; i < input.length() && valid == true; i++) {
			if (numbers.indexOf(input.substring(i, i + 1)) == -1) {
				valid = false;
			}
		}
		if (input.length() != NUM_LENGTH) {
			valid = false;
		}

		while (!valid) {
			valid = true;
			System.out.print("Please enter a 10-digit number: ");
			input = keyboard.nextLine();

			for (int i = 0; i < input.length() && valid == true; i++) {
				if (numbers.indexOf(input.substring(i, i + 1)) == -1) {
					valid = false;
				}
			}
			if (input.length() != NUM_LENGTH) {
				valid = false;
			}
		}

		return input;
	}
}