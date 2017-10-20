package com.bayviewglen.arrays;

import java.util.Arrays;

public class AddressBookOld {
	private Contact[] contacts;
	private int numContacts;

	public AddressBookOld() {
		contacts = new Contact[1000];
		numContacts = 0;
	}

	public String toString() {
		String print = "";

		Arrays.sort(contacts, 0, numContacts, new SortClassByName());

		for (int j = 0; j < numContacts; j++) {
			print += contacts[j] + "\n";
		}

		return print;
	}

	public void add(Contact contact) {
		int index = -1;

		for (int i = 0; i < numContacts; i++) {
			if (contact.compareTo(contacts[i]) == 0) {
				index = i;
			}
		}

		if (index == -1) {
			contacts[numContacts] = contact;
			numContacts += 1;
			System.out.print("Contact added: " + contact + "\n");
		} else {
			System.out.println("This contact already exists.");
		}
	}

	public void read(Contact contact) {
		contacts[numContacts] = contact;
		numContacts += 1;
	}

	public void delete(String first, String last) {
		int index = -1;
		for (int i = 0; i < numContacts; i++) {
			if (contacts[i].getFirst().equals(first) && contacts[i].getLast().equals(last)) {
				index = i;
			}
		}

		if (index == -1) {
			System.out.println("This contact does not exist.");
		} else {
			for (int j = index; j < numContacts; j++) {
				contacts[j] = contacts[j + 1];
			}
		}

		numContacts--;
	}

	public void search(String first, String last) {
		int index = -1;
		for (int i = 0; i < numContacts; i++) {
			if (contacts[i].getFirst().equals(first) && contacts[i].getLast().equals(last)) {
				index = i;
			}
		}

		if (index == -1) {
			System.out.println("This contact does not exist.");
		} else {
			System.out.println(contacts[index]);
		}
	}

	public String getNumContacts() {
		return ("" + numContacts);
	}

	public void setNumContacts(int num) {
		numContacts = num;
	}
}
