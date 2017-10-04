package com.bayviewglen.trees;

public class TreeDriver {

	public static void main(String[] args) {
		BST sal = new BST();
		sal.add(8);
/*		sal.add(7);
		sal.add(6);
		sal.add(3);
		sal.add(2);
		sal.add(5);
		sal.add(4);*/
		
		sal.add(9);
		sal.add(11);
		sal.add(10);
		sal.add(13);
		sal.add(12);
		sal.add(14);		
		sal.delete(11);
		
		System.out.println(sal.getRoot().getData());
		System.out.println(" " + sal.getRoot().getRight().getData());
		System.out.println("  " + sal.getRoot().getRight().getRight().getData());
		System.out.print("" + sal.getRoot().getRight().getRight().getLeft().getData());
		System.out.println(" " + sal.getRoot().getRight().getRight().getRight().getData());
		System.out.println("     " + sal.getRoot().getRight().getRight().getRight().getRight().getData());
	}
}