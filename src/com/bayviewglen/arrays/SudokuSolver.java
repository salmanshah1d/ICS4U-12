package com.bayviewglen.arrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SudokuSolver {

	public static void main(String[] args) {
		int[][] grid = new int[9][9];
		read(grid);
		boolean valid = true;
		// print(grid);

		for (int a = 0; a < grid.length; a += 3) {
			for (int j = 0; j < grid[a].length; j += 3) {
				if (!checkBox(grid, a, j)) {
					valid = false;
				}
			}
		}

		for (int i = 0; i < grid.length && valid; i++) {

			if (!checkVertical(grid, i)) {
				valid = false;
			}

			if (!checkHorizontal(grid, i)) {
				valid = false;
			}
		}

		if (valid) {
			System.out.println("This solution is valid.");
		} else {
			System.out.println("This solution is invalid.");
		}

	}

	private static boolean checkHorizontal(int[][] grid, int i) {
		for (int a = i; a < 9; a++) {
			if (count(grid[i], a) > 1) {
				return false;
			}
		}
		return true;
	}

	private static int count(int[] grid, int i) {
		int count = 0;
		for (int z = 0; z < grid.length; z++) {
			if (grid[z] == grid[i]) {
				count++;
			}
		}
		return count;
	}

	private static boolean checkVertical(int[][] grid, int i) {
		int[] newArr = new int[grid.length];

		for (int b = 0; b < grid.length; b++) {
			newArr[b] = grid[b][i];
		}

		for (int a = i; a < 9; a++) {
			if (count(newArr, a) > 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkBox(int[][] grid, int i, int j) {
		int[] newArr = new int[9];
		int count = 0;
		
		for (int p = i; p < i + 3; p++) {
			for (int l = j; l < j + 3; l++) {
				newArr[count] = grid[p][l];
				count++;
			}
		}

		for (int a = i; a < 9; a++) {
			if (count(newArr, a) > 1) {
				return false;
			}
		}
		return true;
	}

	private static void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
				if ((j + 1) % 3 == 0) {
					System.out.print("| ");
				}
			}
			System.out.println("");
			if ((i + 1) % 3 == 0) {
				System.out.println("-----------------------");
			}
		}
	}

	private static void read(int[][] grid) {
		try {
			Scanner input = new Scanner(new FileReader("data/sudoku.dat"));
			String line;
			for (int i = 0; i < grid.length; i++) {
				line = input.nextLine();
				for (int j = 0; j < grid[i].length; j++)
					grid[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}