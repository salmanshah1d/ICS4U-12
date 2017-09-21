package com.bayviewglen.arrays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		String[][] grid = new String[3][3];
		populate(grid);
		// print(grid); made this to test if array was properly populated
		boolean win = false;
		boolean validGame = isValid(grid);

		if (validGame) {
			if (!win) {
				for (int i = 0; i < 3; i++) {
					if (checkHorizontal(grid[i]) == true) {
						win = true;
						System.out.println(" has won!");
					}

					if (checkVertical(grid, i) == true) {
						win = true;
						System.out.println(" has won!");
					}
				}

				if (checkDiagonal(grid, 0) == true) {
					win = true;
					System.out.println(" has won!");
				}

				if (checkDiagonal(grid, 2) == true) {
					win = true;
					System.out.println(" has won!");
				}
			} 
			
			if (!win) {
				System.out.println("It was a tie!");
			}
		} else {
			System.out.println("This is not a valid, completed game.");
		}
	}

	/*
	 * private static void print(String[][] grid) { for (int i = 0; i < grid.length;
	 * i++) { for (int j = 0; j < grid[i].length; j++) { System.out.print(grid[i][j]
	 * + " "); } System.out.println(""); } }
	 */

	private static boolean checkDiagonal(String[][] grid, int j) {
		int xCount = 0, oCount = 0;
		
		if (j == 0) {
			xCount = 0; 
			oCount = 0;
			if (grid[0][0].equals("X")) {
				xCount++;
			}
			
			if (grid[1][1].equals("X")) {
				xCount++;
			}
			
			if (grid[2][2].equals("X")) {
				xCount++;
			}

			if (grid[0][0].equals("O")) {
				oCount++;
			}
			
			if (grid[1][1].equals("O")) {
				oCount++;
			}
			
			if (grid[2][2].equals("O")) {
				oCount++;
			}
			
			if (xCount == 3) {
				System.out.print("X");
				return true;
			}

			if (oCount == 3) {
				System.out.print("O");
				return true;
			}
			
		} else {
			xCount = 0; 
			oCount = 0;
			if (grid[2][0].equals("X")) {
				xCount++;
			}
			
			if (grid[1][1].equals("X")) {
				xCount++;
			}
			
			if (grid[0][2].equals("X")) {
				xCount++;
			}

			if (grid[2][0].equals("O")) {
				oCount++;
			}
			
			if (grid[1][1].equals("O")) {
				oCount++;
			}
			
			if (grid[0][2].equals("O")) {
				oCount++;
			}
			
			if (xCount == 3) {
				System.out.print("X");
				return true;
			}

			if (oCount == 3) {
				System.out.print("O");
				return true;
			}
		}
		
		return false;
	}

	private static boolean checkVertical(String[][] grid, int i) {
		int xCount = 0, oCount = 0;
		for (int j = 0; j < grid.length; j++) {
			if (grid[j][i].equals("X")) {
				xCount++;
			}
			if (grid[j][i].equals("O")) {
				oCount++;
			}
		}

		if (xCount == 3) {
			System.out.print("X");
			return true;
		}

		if (oCount == 3) {
			System.out.print("O");
			return true;
		}
		return false;
	}

	private static boolean checkHorizontal(String[] grid) {
		int xCount = 0, oCount = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i].equals("X")) {
				xCount++;
			}
			if (grid[i].equals("O")) {
				oCount++;
			}
		}

		if (xCount == 3) {
			System.out.print("X");
			return true;
		}

		if (oCount == 3) {
			System.out.print("O");
			return true;
		}

		return false;
	}

	private static boolean isValid(String[][] grid) {
		int xCount = 0, oCount = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j].equals("X")) {
					xCount++;
				}
				if (grid[i][j].equals("O")) {
					oCount++;
				}
			}
		}
		
		if (xCount == 5 && oCount == 4) {
			return true;
		}

		if (xCount == 4 && oCount == 5) {
			return true;
		}

		
		return false;
	}

	private static void populate(String[][] grid) {
		try {
			Scanner input = new Scanner(new FileReader("data/tictactoe.dat"));
			String line;
			for (int i = 0; i < grid.length; i++) {
				line = input.nextLine();
				for (int j = 0; j < grid[i].length; j++)
					grid[i][j] = line.substring(j, j + 1);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}