package com.bayviewglen.trees;

import com.bayviewglen.arrays.Contact;

public class TreeNode implements Comparable<Contact> {
	private Comparable data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Comparable data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Comparable getData() {
		return data;
	}

	public void setData(Comparable data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int compareTo(Contact b) {
		if (this.data instanceof Contact) {
			return (((Contact)this.data).getLast() + ((Contact)this.data).getFirst()).compareTo(((Contact)b).getLast()+((Contact)b).getFirst());
		} else {
			return 0;
		}
	}
}