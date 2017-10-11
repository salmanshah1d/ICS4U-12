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
		// add all, show all, search for specific, delete specific
		BST contacts = new BST();
		populate(contacts);
		boolean demo = true;
		String option, first, last, number;
		Scanner keyboard = new Scanner(System.in);
		Contact newContact;

		System.out.println("Welcome to Contacts.");

		while (demo) {
			option = printMenu();

			if (option.equals("1")) {

				System.out.print("Enter first name: ");
				first = alpha(keyboard.nextLine(), 1);
				System.out.print("Enter last name: ");
				last = alpha(keyboard.nextLine(), 2);

				if (contacts.ifExists(first, last)) {
					System.out.println("This contact already exists.");
				} else {
					System.out.print("Enter phone number: ");
					number = numeric((keyboard.nextLine()));
					newContact = new Contact(first, last, number);
					contacts.add(newContact);
					System.out.println(newContact + " has been added.");
				}

			} else if (option.equals("2")) {
				if (contacts.getRoot() == null) {
					System.out.println("This address book is empty.");
				} else {
					contacts.inOrderTraversal(contacts.getRoot());
				}
			} else if (option.equals("3")) {
				System.out.print("Enter first name: ");
				first = alpha(keyboard.nextLine(), 1);
				System.out.print("Enter last name: ");
				last = alpha(keyboard.nextLine(), 2);
				System.out.println(contacts.search(first, last));

			} else if (option.equals("4")) {
				System.out.print("Enter first name: ");
				first = alpha(keyboard.nextLine(), 1);
				System.out.print("Enter last name: ");
				last = alpha(keyboard.nextLine(), 2);
				boolean done = contacts.delete(first, last);
				if (done) {
					System.out.println(first + " " + last + " has been deleted.");
				} else {
					System.out.println(first + " " + last + " does not exist.");
				}

			} else if (option.equals("5")) {
				demo = false;
				save(contacts);
			}

		}

		System.out.print("Thank you. Come again.");

	}

	private static void populate(BST contacts) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("data/words.dat"));
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

	private static void save(BST contacts) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/words.dat"));
		contacts.save(contacts.getRoot(), writer);
		writer.close();
	}

	private static String printMenu() {
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

	private static String textCheck(String input) {
		Scanner keyboard = new Scanner(System.in);
		while (!(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")
				|| input.equals("5"))) {
			System.out.print("Please choose 1, 2, 3, 4, or 5.");
			input = keyboard.nextLine();
		}

		return input;
	}

	private static String alpha(String input, int num) {
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

	private static String numeric(String input) {
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

		// "(" + input.substring(0, 3) + ") " + input.substring(3, 6) + "-" +
		// input.substring(6, 10)
		return input;
	}
}