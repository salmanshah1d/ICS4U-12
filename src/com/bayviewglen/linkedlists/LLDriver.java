package com.bayviewglen.linkedlists;

public class LLDriver {

	public static void main(String[] args) throws ListIndexOutOfBoundsException {
		LinkedList salman = new LinkedList();
		salman.add(0);
		salman.addFirst(1);
		salman.add(6);
		salman.add(2,3);
		salman.add(1,3);
		System.out.println(salman.removeLastOccurence(3));
		salman.set(3, 2);
		
		int[] arr = salman.toArr();
		System.out.print("[");
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(arr[arr.length-1] + "]");
	}
}