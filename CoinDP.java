package javaclasses;

import java.util.Scanner;

public class CoinDP {

	static int[] denom;
	static int[] memory;

	public static int minChange(int x) {
		int min = Integer.MAX_VALUE;
		if (x == 0)
			return 0;
		if (memory[x] != 0)
			return memory[x];
		for (int i = 0; i < denom.length; i++) {
			int temp = 0;
			if (x - denom[i] >= 0) {
				if (x - denom[i] == 0)
					temp = 1;
				else {
					if (memory[x - denom[i]] != 0)
						temp = memory[x - denom[i]] + 1;
					else
						temp = minChange(x - denom[i]) + 1;
				}
			} else
				break;
			if (min > temp)
				min = temp;
		}
		return min;
	}

	public static void main(String[] args) {
		int n;
		int amount;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the number of denom: ");
		n = in.nextInt();
		denom = new int[n];
		System.out.print("Enter the values of denoms in ascending order: ");
		for (int i = 0; i < n; i++) {
			denom[i] = in.nextInt();
		}
		System.out.println("Enter the total to make change: ");
		amount = in.nextInt();
		memory = new int[amount + 1];
		for (int i = 0; i <= amount; i++)
			memory[amount] = 0;
		for (int i = 0; i < denom.length; i++)
			memory[denom[i]] = 1;
		System.out.println("The minimum amount of coins required is "
				+ minChange(amount));
	}

}
