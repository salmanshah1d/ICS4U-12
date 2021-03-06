package com.bayviewglen.stacks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.bayviewglen.utils.Stack;

public class Infix {

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(new FileReader("data/infix.dat"));

		while (reader.hasNext()) {
			String expression = reader.nextLine();
			System.out.println(evaluateInfix(expression.split(" ")));
		}
	}

	private static String evaluateInfix(String[] string) {
		Stack operators = new Stack();
		Stack numbers = new Stack();
		boolean valid = true;
		String operator = "()*/+-";
		Double numOne = 0.0;

		for (int i = 0; i < string.length && valid; i++) {
			if (operator.indexOf(string[i]) != -1) {
				if (string[i].equals(")")) {
					if (operators.empty()) {
						valid = false;
					} else if (operators.peek().equals("(")) {
						operators.pop();
					} else if (operators.peek().equals("+")) {
						numOne = (Double) numbers.pop();
						numbers.push((Double)numbers.pop() + numOne);
						operators.pop();
						operators.pop();
					} else if (operators.peek().equals("-")) {
						numOne = (Double) numbers.pop();
						numbers.push((Double)numbers.pop() - numOne);
						operators.pop();
						operators.pop();
					} else if (operators.peek().equals("*")) {
						numOne = (Double) numbers.pop();
						numbers.push((Double)numbers.pop() * numOne);
						operators.pop();
						operators.pop();
					} else {
						numOne = (Double) numbers.pop();
						numbers.push((Double)numbers.pop() / numOne);
						operators.pop();
						operators.pop();
					}
				} else {
					operators.push(string[i]);
				}

			} else {
				if (operators.peek().equals("+")) {
					numOne = (Double)numbers.pop();
					numbers.push(new Double(string[i]) + numOne);
					operators.pop();
				} else if (operators.peek().equals("-")) {
					numOne = (Double)numbers.pop();
					numbers.push(new Double(string[i]) - numOne);
					operators.pop();
				} else if (operators.peek().equals("*")) {
					numOne = (Double)numbers.pop();
					numbers.push(new Double(string[i]) * numOne);
					operators.pop();
				} else if (operators.peek().equals("/")) {
					numOne = (Double)numbers.pop();
					numbers.push(new Double(string[i]) / numOne);
					operators.pop();
				} else {
					numbers.push(new Double(string[i]));
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