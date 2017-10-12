package com.bayviewglen.trees;

import com.bayviewglen.arrays.Contact;

public class TreeDriver {

	public static void main(String[] args) {
		BST sal = new BST();
		sal.add(new Contact("a", "b", "1"));
		sal.add(new Contact("a", "c", "12"));
		sal.add(new Contact("a", "d", "13"));
		sal.add(new Contact("a", "e", "1234567890"));
	}
}