package com.bayviewglen.linkedlists;

public class ListIndexOutOfBoundsException extends Exception { // prints a self-made expression specifically for linked
																// list
	public String getMessage() {
		return "List index is out-of-bounds.";
	}
}