package com.bayviewglen.backtracking;

import java.util.Scanner;
import java.util.Stack;

public class nQueens {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int n = keyboard.nextInt();
		boolean conflict = false, placed = false;
		Stack queens = new Stack<Queen>();
		int filled = 1;
		Queen a = new Queen(filled, 0);

		while (filled <= n) {
			conflict = checkConflict(a, queens);
			System.out.println(conflict);
			
			if (!conflict) {
				queens.push(a);
				placed = true;
			} else {
				placed = false;
				while (a.getCol() < n && !placed) {
					System.out.println("ay");
					a.setCol(a.getCol() + 1);
					conflict = checkConflict(a, queens);
					if (!conflict) {
						queens.push(a);
						placed = true;
					}
				}
				
				if (!placed) {
					while (((Queen) queens.peek()).getCol() == n) {
						filled--;
						queens.pop();
					}
					a = ((Queen) queens.pop());
					a.setCol(a.getCol()+1);
				}
			}

		}

		/*
		 * while (filled <= n) { Queen a = new Queen(filled, 0); Stack<Queen> newQueens
		 * = new Stack<Queen>(); newQueens.addAll(queens);
		 * 
		 * while (!newQueens.isEmpty()) { if (a.conflict(newQueens.pop())) { conflict =
		 * true; } }
		 * 
		 * if (!conflict) { queens.push(a); placed = true; } else if (conflict) {
		 * a.setCol(a.getCol() + 1); placed = false; while (!placed && a.getCol() <= n)
		 * { newQueens = new Stack<Queen>(); newQueens.addAll(queens);
		 * 
		 * while (!newQueens.isEmpty()) { if (a.conflict(newQueens.pop())) { conflict =
		 * true; } }
		 * 
		 * if (!conflict) { queens.push(a); placed = true; } else { a.setCol(a.getCol()
		 * + 1); conflict = false; placed = false; } }
		 * 
		 * while (!placed) { while (((Queen) queens.peek()).getCol() == n) { filled--;
		 * queens.pop(); }
		 * 
		 * a = (Queen) queens.pop(); a.setCol(a.getCol()+1);
		 * 
		 * newQueens = new Stack<Queen>(); newQueens.addAll(queens);
		 * 
		 * while (!newQueens.isEmpty()) { if (a.conflict(newQueens.pop())) { conflict =
		 * true; } }
		 * 
		 * if (!conflict) { queens.push(a); placed = true; } else if (conflict) {
		 * a.setCol(a.getCol() + 1); placed = false; while (!placed && a.getCol() <= n)
		 * { newQueens = new Stack<Queen>(); newQueens.addAll(queens);
		 * 
		 * while (!newQueens.isEmpty()) { if (a.conflict(newQueens.pop())) { conflict =
		 * true; } }
		 * 
		 * if (!conflict) { queens.push(a); placed = true; } else { a.setCol(a.getCol()
		 * + 1); conflict = false; placed = false; } }
		 * 
		 * while (!placed && a.getCol() <= n) { newQueens = new Stack<Queen>();
		 * newQueens.addAll(queens);
		 * 
		 * while (!newQueens.isEmpty()) { if (a.conflict(newQueens.pop())) { conflict =
		 * true; } }
		 * 
		 * if (!conflict) { queens.push(a); placed = true; } else { a.setCol(a.getCol()
		 * + 1); conflict = false; placed = false; } } } } filled++; }
		 */
		System.out.println(((Queen) queens.pop()).getRow());
		display(queens, n);
	}

	private static boolean checkConflict(Queen a, Stack queens) {
		Stack<Queen> newQueens = new Stack<Queen>();
		newQueens.addAll(queens);

		while (!newQueens.isEmpty()) {
			if (a.conflict(newQueens.pop())) {
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
			for (int col = 0; col < n; col++) {
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