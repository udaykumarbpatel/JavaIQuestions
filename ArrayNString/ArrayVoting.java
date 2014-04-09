package javaclasses;

public class ArrayVoting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 1, 4 };
		System.out.println(isMajority(a));
		
	}

	public static int findMajorityElement(int arr[]) {
		if (arr == null)
			return Integer.MIN_VALUE;
		int length = arr.length;
		int majorIndex = 0;
		int count = 1;
		for (int i = 0; i < length; i++) {
			if (arr[majorIndex] == arr[i])
				count++;
			else
				count--;
			if (count == 0) {
				majorIndex = i;
				count = 1;
			}
		}
		return arr[majorIndex];
	}

	public static boolean isMajority(int arr[]) {
		if (arr == null)
			return false;
		int element = findMajorityElement(arr);
		int length = arr.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] == element)
				count++;
		}
		if (count > length / 2)
			return true;
		return false;
	}

	

}
