package com.bayviewglen.dynamicProgramming;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		execute();
	}

	private static void execute() {
		try {
			Scanner input = new Scanner(new FileReader("data/numbers.dat"));
			while (input.hasNext()) {
				int n = Integer.parseInt(input.nextLine().trim());
				int[] nums = new int[3];
				String numbers = input.nextLine();
				nums[0] = Integer.parseInt(numbers.split(" ")[0].trim());
				nums[1] = Integer.parseInt(numbers.split(" ")[1].trim());
				nums[2] = Integer.parseInt(numbers.split(" ")[2].trim());

				int[] arr = new int[n + 1];
				
				if (nums[2] > nums[1]) {
					int temp = nums[1];
					nums[1] = nums[2];
					nums[2] = temp;
				} 
				
				if (nums[1] > nums[0]) {
					int temp = nums[0];
					nums[0] = nums[1];
					nums[1] = temp;
				} 
				
				if (nums[2] > nums[1]) {
					int temp = nums[2];
					nums[2] = nums[1];
					nums[1] = temp;
				} 
								
				for (int i = 0; i <= n; i++) {
					arr[i] = -1;
				}

				arr[1] = 0;
				
				System.out.println(answer(n, nums, arr));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String answer(int n, int[] nums, int[] arr) {
		String[] str = new String[n + 1];
		int min = 0;
		String minimum = "";
		
		for (int i = 2; i <= n; i++) {
			
			min = 1 + arr[i-1];
			
			if (i % nums[0] == 0 && arr[i / nums[0]] < min) {
				min = 1 + Math.min(arr[i / nums[0]], min);
				minimum = "divided by " + nums[2] + str[i / nums[2]] + " ";
				
			} else if (i % nums[1] == 0 && arr[i / nums[1]] < min) {
				min = 1 + Math.min(arr[i / nums[1]], min);
				str[i] = "divided by " + str[i / nums[1]]  + " ";
				
			} else if (i % nums[2] == 0 && arr[i / nums[2]] < min) {
				min = 1 + Math.min(arr[i / nums[2]], min);
				str[i] = "divided by " + str[i / nums[2]]  + " ";
				
			} else {
				min = 1 + Math.min(arr[i - i], min);
				str[i] = "divided by " + str[i - 1]  + " ";
			}
			arr[i] = 1 + min;
			str[i] = minimum;
		}
		return arr[n] + "\n" + str[n];
	}
}