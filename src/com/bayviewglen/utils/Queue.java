package com.bayviewglen.utils;

public class Queue {
	Object[] queue;
	int length = 0;

	public Queue() {
		queue = new Object[10];
	}

	public void enqueue(Object o) {
		if (length >= 10) {
			Object[] tempQueue = queue;
			queue = new Object[tempQueue.length * 2];
				
			for (int i = 0; i < length; i++) {
				queue[i] = tempQueue[i];
			}
			
			queue[length] = o;
			length++;
		} else {
			queue[length] = o;
			length++;
		}
	}

	public Object dequeue(Object o) {
		Object temp = queue[0];
		
		for (int i = 0; i < length - 1; i++) {
			queue[i] = queue[i + 1];
		}
		
		length--;
		
		return (temp);
	}

	public Object peek(Object o) {
		return queue[0];
	}

	public void clear(Object o) {
		queue = new Object[10];
		length = 0;
	}

	public Boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}
}