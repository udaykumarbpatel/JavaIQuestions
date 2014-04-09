package javaclasses;

import java.util.Scanner;

public class MaxSumDP {
	static int[] sequence;
	static int[] memory;

	public static int MaxSum(int[] x) {
		int len = x.length;
		int max = 0;
		int status = 0;
		int temp;
		memory[0] = sequence[0];
		// int temp;
		for (int i = 0; i < len; i++) {
			if (sequence[i] > 0) {
				status = 1;
				break;
			}
		}
		if (status == 1) {
			for (int i = 1; i < len; i++) {
				temp = memory[i - 1] + sequence[i];
				if (temp > 0) {
					memory[i] = temp;
					if (max < memory[i])
						max = memory[i];

				} else
					memory[i] = 0;
			}

		} else {
			max = sequence[0];
			for (int i = 1; i < len; i++) {
				if (sequence[i] > max)
					max = sequence[i];
			}

		}
		return max;
	}

	public static void main(String[] args) {
		int length = 0;
		Scanner a = new Scanner(System.in);
		System.out.println("Enter the length of your sequence: ");
		length = a.nextInt();
		sequence = new int[length];
		memory = new int[length];
		for (int i = 0; i < sequence.length; i++) {
			memory[i] = 0;
		}
		System.out.println("Enter the element of your sequence one by one: ");
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = a.nextInt();
		}
		System.out
				.println("Maximum contiguous sub-sequence sum of the given sequence is : "
						+ MaxSum(sequence));
	}

}