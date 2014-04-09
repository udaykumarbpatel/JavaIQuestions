package javaclasses;

import java.util.HashMap;

public class ArraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 0, 1, 1, 1, 4 };
		findNumber(a,5);

	}

	public static void findNumber(int[] arr, int sumvalue) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hash.get(arr[i]) == null) {
				int x = sumvalue - arr[i];
				hash.put(arr[i], x);
				if (hash.get(x) != null) {
					System.out.println("The two numbers - " + arr[i] + " and "
							+ x);
				}

			}
		}

	}

}
