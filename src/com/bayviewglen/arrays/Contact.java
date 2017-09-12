package com.bayviewglen.arrays;

public class Contact{
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
	
	public int compare(Contact b) {
		return (this.getLast() + this.getFirst()).compareTo(b.getLast()+b.getFirst());
	}
}
