package com.bayviewglen.arrays;

import java.util.Arrays;

import com.bayviewglen.trees.BST;

public class AddressBook {
	private BST contacts;
	private int numContacts;

	public AddressBook() {
		contacts = new BST();
		numContacts = 0;
	}

	public String toString() {
		contacts.inOrderTraversal(contacts.getRoot());
		return ("");
	}

	public void add(Contact contact) {
		if (contacts.ifExists(contact)) {
			System.out.println("This contact already exists.");
		} else {
			contacts.add(contact);
			numContacts += 1;
			System.out.print("Contact added: " + contact + "\n");
		}
	}

	public void read(Contact contact) {
		contacts.add(contact);
		numContacts += 1;
	}

	public void delete(String first, String last) {
		boolean deleted = contacts.delete(first, last);
		
		if (deleted) {
			numContacts--;
			System.out.println("Deleted.");
		} else {
			System.out.println("Contact not found");
		}
	}

	public void search(String first, String last) {
		contacts.search(first, last);
	}

	public String getNumContacts() {
		return ("" + numContacts);
	}

	public void setNumContacts(int num) {
		numContacts = num;
	}
}
