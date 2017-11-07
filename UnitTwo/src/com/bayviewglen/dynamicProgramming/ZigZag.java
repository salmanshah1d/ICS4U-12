package com.bayviewglen.dynamicProgramming;

public class ZigZag {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 7, 7, 4, 4, 9, 9, 5, 5, 6, 7, 7, 1 };

		int[] incr = new int[arr.length];
		int[] decr = new int[arr.length];

		incr[0] = 1;
		decr[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) { // (so it's increasing)
				incr[i] = decr[i - 1] + 1;
				decr[i] = decr[i - 1];
			} else if (arr[i - 1] == arr[i]) {
				incr[i] = incr[i - 1];
				decr[i] = decr[i - 1];
			} else {
				decr[i] = incr[i - 1] + 1;
				incr[i] = incr[i - 1];
			}
		}

		System.out.println("The length of the longest subsequence is "
				+ Math.max(incr[arr.length - 1], decr[arr.length - 1]) + ".");
	}

	/*
	 * private static int[] populate() { try { Scanner input = new Scanner(new
	 * FileReader("data/numbers.dat")); while (input.hasNext()) { int n =
	 * Integer.parseInt(input.nextLine().trim()); int[] nums = new int[3]; String
	 * numbers = input.nextLine(); nums[0] =
	 * Integer.parseInt(numbers.split(" ")[0].trim()); nums[1] =
	 * Integer.parseInt(numbers.split(" ")[1].trim()); nums[2] =
	 * Integer.parseInt(numbers.split(" ")[2].trim());
	 * 
	 * int[] arr = new int[n + 1];
	 * 
	 * if (nums[2] > nums[1]) { int temp = nums[1]; nums[1] = nums[2]; nums[2] =
	 * temp; }
	 * 
	 * if (nums[1] > nums[0]) { int temp = nums[0]; nums[0] = nums[1]; nums[1] =
	 * temp; }
	 * 
	 * if (nums[2] > nums[1]) { int temp = nums[2]; nums[2] = nums[1]; nums[1] =
	 * temp; }
	 * 
	 * for (int i = 0; i <= n; i++) { arr[i] = -1; }
	 * 
	 * arr[1] = 0;
	 * 
	 * System.out.println(execute(n, nums, arr)); } } catch (FileNotFoundException
	 * e) { e.printStackTrace(); } }
	 */
}