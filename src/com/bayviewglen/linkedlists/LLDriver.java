package com.bayviewglen.linkedlists;

public class LLDriver {

	public static void main(String[] args) throws ListIndexOutOfBoundsException {
		LinkedList salman = new LinkedList();
		salman.add(1);
		salman.add(2);
		salman.add(3);
		salman.add(2);
		salman.add(1);
		salman.removeLastOccurence(1);
		salman.set(1, 5);
		
		System.out.println(salman.size());
		System.out.println(salman);
	}
}