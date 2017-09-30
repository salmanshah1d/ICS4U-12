package com.bayviewglen.packages;

public class BST {
	IntTreeNode root;

	public BST(IntTreeNode root) {
		super();
		this.root = root;
	}

	public BST() {
		super();
		this.root = null;
	}

	public IntTreeNode getRoot() {
		return root;
	}

	public void add(IntTreeNode current, int x) {
		IntTreeNode temp = new IntTreeNode(x);
		
		if (current == null) {
			current = temp;
		} else if (current.getData() > x) {
			add(current.getLeft(), x);
		} else if (current.getData() <= x) {
			add(current.getRight(), x);
		}
	}
	
	public void add(int x) {
		if (root == null) {
			IntTreeNode temp = new IntTreeNode(x);
			root = temp;
		} else { 	
			add(root, x);
		}
	}
	
	public int search(IntTreeNode root) {
		return 0;
	}
	
	public void inOrderTraversal(IntTreeNode current) {
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		} 
		evaluate (current);
		if (current.getLeft() != null) {
			inOrderTraversal(current.getRight());
		} 
	}
	
	public void preorderTraversal(IntTreeNode current) {
		evaluate (current);
		
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		} 
		
		if (current.getLeft() != null) {
			inOrderTraversal(current.getRight());
		} 
	}
	
	public void postorderTraversal(IntTreeNode current) {
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		} 
		
		if (current.getLeft() != null) {
			inOrderTraversal(current.getRight());
		}
		
		evaluate (current);
	}
	
	private void evaluate(IntTreeNode current) {
		System.out.println(current.getData());
	}
}