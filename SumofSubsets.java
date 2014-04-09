package javaclasses;

import java.util.Arrays;
import java.util.LinkedList;

public class SumofSubsets {
	private static LinkedList<Integer> subset = new LinkedList<Integer>();;
	static int sum = 0;

	public static void findSubset(int[] numbers, int startPoint, int number) {
		if (sum == number) {
			System.out.println(subset + " :: " + sum);
		} else
			for (int i = startPoint; i < numbers.length; i++) {
				sum = sum + numbers[i];
				if (sum > number) {
					sum = sum - numbers[i];
					break;
				}
				subset.add((int) numbers[i]);
				findSubset(numbers, i + 1, number);
				sum = sum - numbers[i];
				subset.removeLast();
			}
	}

	public static void main(String args[]) {
		int[] numbers = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9 };
		int total = 13;
		Arrays.sort(numbers);
		findSubset(numbers, 0, total);
	}
}
