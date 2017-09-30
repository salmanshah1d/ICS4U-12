package com.bayviewglen.linkedlists;

import java.util.NoSuchElementException;

public class LinkedList {
	private IntNode head;
	private IntNode tail;
	private int numNodes;

	public LinkedList() {
		head = null;
		tail = null;
		numNodes = 0;
	}

	public void addFirst(int x) {
		head = new IntNode(x, head);
		if (numNodes == 0) {
			tail = head;
		}

		numNodes++;
	}

	public void add(int index, int value) {
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

	public boolean add(int value) {
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

	public void clear() {
		head = null;
		tail = null;
		numNodes = 0;
	}

	public boolean contains(int value) {
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

	public int get(int index) throws ListIndexOutOfBoundsException {
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

	public int getFirst() throws NoSuchElementException {
		if (numNodes == 0) {
			throw new NoSuchElementException();
		} else {
			return head.getData();
		}
	}

	public int getLast() throws NoSuchElementException {
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

	public int remove(int index) {
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

	public int removeFirst() throws NoSuchElementException {
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

	public boolean removeFirstOccurence(int value) {
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

	public int removeLast() throws NoSuchElementException {
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

	public boolean removeLastOccurence(int value) throws NoSuchElementException {
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

	public int set(int index, int value) throws ListIndexOutOfBoundsException {
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

	public int size() {
		return numNodes;
	}

	public int[] toArr() {
		int[] arr = new int[numNodes];
		IntNode current = head;
		for (int i = 0; i < numNodes; i++) {
			arr[i] = current.getData();
			current = current.getLink();
		}
		return arr;
	}

	public String toString() {
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