package com.bayviewglen.backtracking;

import java.util.Scanner;
import java.util.Stack;

public class nQueens {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int n = keyboard.nextInt();
		while (n <= 3) {
			System.out.println("Your input has to be larger than 3.");
			System.out.print("Please enter another number: ");
			n = keyboard.nextInt();
		}
		boolean conflict = false;
		Stack queens = new Stack<Queen>();
		int filled = 1;
		Queen a = new Queen(filled, 1);

		while (filled <= n) {
			conflict = checkConflict(a, queens);

			if (!conflict) {
				filled++;
				queens.push(a);
				a = new Queen(filled, 1);

			} else {
				if (a.getCol() < n) {
					a.setCol(a.getCol() + 1);
				} else {
					while (((Queen) queens.peek()).getCol() == n) {
						a = (Queen) queens.pop();
						filled--;
					}
					a = (Queen) queens.pop();
					filled--;
					a.setCol(a.getCol()+1);
				}
			}

		}
		display(queens, n);
	}

	private static boolean checkConflict(Queen a, Stack queens) {
		Stack<Queen> newQueens = new Stack<Queen>();
		newQueens.addAll(queens);

		while (!newQueens.isEmpty()) {
			Queen popped = newQueens.pop();
			if (a.conflict(popped)) {
				return true;
			}
		}

		return false;
	}

	private static void display(Stack<Queen> queens, int n) {
		Stack<Queen> newQueens = new Stack<Queen>();
		newQueens.addAll(queens);
		boolean found = false;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				while (!newQueens.isEmpty()) {
					Queen temp = newQueens.pop();
					if (temp.getCol() == col && temp.getRow() == row) {
						System.out.print("X ");
						found = true;
					}
				}
				newQueens.addAll(queens);
				if (!found) {
					System.out.print("- ");
				} else {
					found = false;
				}
			}
			System.out.println("");
		}
	}
}