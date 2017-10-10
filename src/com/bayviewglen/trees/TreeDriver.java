package com.bayviewglen.trees;

import com.bayviewglen.arrays.Contact;

public class TreeDriver {

	public static void main(String[] args) {
		BST sal = new BST();
		GeneralBST salman = new GeneralBST();
		sal.add((Comparable)new Contact("Salman","Shahid","6479099672"));
		sal.add((Comparable)new Contact("Salman","Sgahid","6479099672"));
		sal.add((Comparable)new Contact("Salman","Sjahid","6479099672"));
		sal.add((Comparable)new Contact("Salman","Siahid","6479099672"));
		sal.add((Comparable)new Contact("Salman","Skahid","6479099672"));
		sal.delete("Salman", "Shahid");
		
		System.out.println("             " + sal.getRoot().getData());
		System.out.print(sal.getRoot().getLeft().getData());
		System.out.println("   " + sal.getRoot().getRight().getData());
		System.out.println("                               " + sal.getRoot().getRight().getRight().getData());
		
		/*salman.add(0);
		salman.add(1);
		salman.add(3);
		salman.add(2);
		salman.delete(0);
		
		System.out.println(salman.getRoot().getData());*/
	}
}