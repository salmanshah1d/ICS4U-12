package com.bayviewglen.stacks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new FileReader("data/postfix.dat"));

		while (reader.hasNext()) {
			String expression = reader.nextLine();
			System.out.println(evaluatePostfix(expression.split(" ")));
		}
	}

	private static String evaluatePostfix(String[] string) {
		Stack<Double> numbers = new Stack<Double>();
		boolean valid = true;
		String operator = "*/+-";
		Double numOne = 0.0;
		Double numTwo = 0.0;

		for (int i = 0; i < string.length && valid; i++) {
			if (operator.indexOf(string[i]) == -1) {
				numbers.push(new Double(string[i]));
			} else {
				if (string[i].equals("+")) {
					numOne = numbers.pop();
					numTwo = numbers.pop();
					numbers.push(numOne + numTwo);
				} else if (string[i].equals("-")) {
					numOne = numbers.pop();
					numTwo = numbers.pop();
					numbers.push(numOne - numTwo);
				} else if (string[i].equals("*")) {
					numOne = numbers.pop();
					numTwo = numbers.pop();
					numbers.push(numOne * numTwo);
				} else {
					numOne = numbers.pop();
					numTwo = numbers.pop();
					numbers.push(numOne / numTwo);
				}
			}
		}
		
		if (valid) {
			return ("" + numbers.pop());
		} else {
			return ("Sorry, this is not a valid input.");
		}

	}
}