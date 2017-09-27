package com.bayviewglen.utils;

public class Stack {
	Object[] stack;
	int length = 0;

	public Stack() {
		stack = new Object[10];
	}

	public void push(Object o) {
		if (length >= 10) {
			Object[] tempStack = stack;
			stack = new Object[20];
			
			for (int i = 0; i < 10; i++) {
				stack[i] = tempStack[i];
			}
			
			length++;
		} else {
			stack[length] = o;
			length++;
		}
	}

	public Object pop() {
		return stack[--length];
	}

	public Object peek() {
		return stack[length - 1];
	}

	public boolean empty() {
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}
}
