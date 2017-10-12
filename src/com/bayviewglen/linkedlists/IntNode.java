package com.bayviewglen.linkedlists;

public class IntNode {
	private int data;
	private IntNode link;

	public IntNode() { // constructor
		super();
		data = 0;
		link = null;
	}

	public IntNode(int data, IntNode link) { // constructor 2
		super();
		this.data = data;
		this.link = link;
	}

	public int getData() { // returns data of the node
		return data;
	}

	public void setData(int data) { // sets data of the node
		this.data = data;
	}

	public IntNode getLink() { // gets the link of the node
		return link;
	}

	public void setLink(IntNode link) { // sets the link of the node
		this.link = link;
	}

}