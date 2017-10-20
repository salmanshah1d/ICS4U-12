package com.bayviewglen.linkedlists;

import java.util.NoSuchElementException;

public class LinkedList {
	private IntNode head;
	private IntNode tail;
	private int numNodes;

	public LinkedList() { // constructor
		head = null;
		tail = null;
		numNodes = 0;
	}

	public boolean add(int value) { // Appends the specified element to the end of this list.
		if (numNodes == 0) {
			addFirst(value);
		} else {
			IntNode newNode = new IntNode(value, null);
			tail.setLink(newNode);
			tail = newNode;
			numNodes++;
		}
		return true;
	}

	public void add(int index, int value) { // Inserts the specified element at the specified position in this list.
		if (index == 0) {
			addFirst(value);
		} else {
			IntNode current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getLink();
			}
			current.setLink(new IntNode(value, current.getLink()));
			numNodes++;
		}
	}

	public void addFirst(int x) { // Inserts the specified element at the beginning of this list.
		head = new IntNode(x, head);
		if (numNodes == 0) {
			tail = head;
		}

		numNodes++;
	}

	public void clear() { // Removes all of the elements from this list.
		head = null;
		tail = null;
		numNodes = 0;
	}

	public boolean contains(int value) { // Returns true if this list contains the specified element.
		IntNode current = head;
		for (int i = 0; i < numNodes; i++) {
			if (current.getData() == value) {
				return true;
			} else {
				current = current.getLink();
			}
		}
		return false;
	}

	public int get(int index) throws ListIndexOutOfBoundsException { // Returns the element at the specified position in
																		// this list.
		IntNode current = head;
		if (index > numNodes) {
			throw new ListIndexOutOfBoundsException();
		} else {
			for (int i = 0; i < index; i++) {
				current = current.getLink();
			}
			return current.getData();
		}
	}

	public int getFirst() throws NoSuchElementException { // Returns the first element in this list.
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			return head.getData();
		}
	}

	public int getLast() throws NoSuchElementException { // Returns the last element in this list.
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			IntNode current = head;
			for (int i = 0; i < numNodes - 1; i++) {
				current = current.getLink();
			}
			return current.getData();
		}
	}

	public int removeFirst() throws NoSuchElementException { // Retrieves and removes the head (first element) of this
																// list.
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			int value = head.getData();
			head = head.getLink();
			if (numNodes == 1) {
				tail = null;
			}
			numNodes--;
			return value;
		}
	}

	public int remove(int index) { // Removes the element at the specified position in this list.
		if (index > numNodes) {
			throw new NoSuchElementException();
		} else {
			if (index == 0) {
				return removeFirst();
			} else if (index == numNodes - 1) {
				return removeLast();
			} else {
				IntNode current = head;

				for (int i = 0; i < index - 1; i++) {
					current = current.getLink();
				}

				int i = current.getLink().getData();
				current.setLink(current.getLink().getLink());

				if (i == numNodes - 1) {
					tail = current;
				}

				numNodes--;
				return i;
			}
		}
	}

	public boolean removeFirstOccurence(int value) { // Removes the first occurrence of the specified element in this
														// list (when traversing the list from head to tail).
		IntNode current = head;
		if (current.getData() == value) {
			removeFirst();
		} else {
			for (int i = 0; i < numNodes - 1; i++) {
				if (current.getLink().getData() == value) {
					current.setLink(current.getLink().getLink());
					if (i == numNodes - 2) {
						tail = current;
					}
					numNodes--;
					return true;
				} else {
					current = current.getLink();
				}
			}
		}

		return false;
	}

	public int removeLast() throws NoSuchElementException { // Removes and returns the last element from this list.
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			IntNode current = head;
			for (int i = 0; i < numNodes - 2; i++) {
				current = current.getLink();
			}
			int i = current.getLink().getData();
			current.setLink(null);
			numNodes--;
			tail = current;
			return i;
		}
	}

	public boolean removeLastOccurence(int value) throws NoSuchElementException { // Removes the last occurrence of the
																					// specified element in this list
																					// (when traversing the list from
																					// head to tail).
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			IntNode current = head;
			int index;
			if (current.getData() == value) {
				index = 0;
			} else {
				index = -1;
			}

			for (int i = 0; i < numNodes; i++) {
				if (current.getData() == value) {
					index = i;
				}
				current = current.getLink();
			}

			if (index == -1) {
				return false;
			} else if (index == 0) {
				removeFirst();
				return true;
			} else if (index == numNodes - 1) {
				removeLast();
				return true;
			} else {
				current = head;
				for (int i = 0; i < index - 1; i++) {
					current = current.getLink();
				}

				current.setLink(current.getLink().getLink());
				if (index == numNodes - 1) {
					tail = current;
				}

				numNodes--;
				return true;
			}
		}
	}

	public int set(int index, int value) throws ListIndexOutOfBoundsException { // Replaces the element at the specified
																				// position in this list with the
																				// specified element.
		IntNode current = head;
		if (index > numNodes) {
			throw new ListIndexOutOfBoundsException();
		} else {
			for (int i = 0; i < index + 1; i++) {
				if (i == index) {
					current.setData(value);
					return value;
				} else {
					current = current.getLink();
				}
			}
		}

		return -1;
	}

	public int size() { // Returns the number of elements in this list.
		return numNodes;
	}

	public int[] toArr() { // Returns an array containing all of the elements in this list in proper
							// sequence (from first to last element).
		int[] arr = new int[numNodes];
		IntNode current = head;
		for (int i = 0; i < numNodes; i++) {
			arr[i] = current.getData();
			current = current.getLink();
		}
		return arr;
	}

	public String toString() { // Prints the LinkedList.
		String str = "";
		int[] arr = this.toArr();
		str += ("[");
		for (int i = 0; i < arr.length - 1; i++) {
			str += (arr[i] + " ");
		}
		str += (arr[arr.length - 1] + "]");
		return str;
	}
}