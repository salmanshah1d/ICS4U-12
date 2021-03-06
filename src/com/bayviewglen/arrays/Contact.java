package com.bayviewglen.arrays;

public class Contact implements Comparable<Contact> {
	private String first;
	private String last;
	private String number;

	public Contact() {

	}

	public Contact(String first, String last, String number) {
		super();
		this.first = first;
		this.last = last;
		this.number = number;
	}

	public Contact(String first, String last) {
		super();
		this.first = first;
		this.last = last;
		this.number = null;
	}
	
	public String toString() {
		return first + " " + last + " " + number;
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public int compareTo(Contact b) {
		return (this.getLast() + this.getFirst()).compareTo(b.getLast() + b.getFirst());
	}

	public String toString2() {
		return first + " " + last + " " + "(" + number.substring(0, 3) + ") " + number.substring(3, 6) + "-" + number.substring(6, number.length());
	}
}