/*
 * Given n. Generate all numbers with number of digits equal to n, 
 * such that the digit to the right is greater than the left digit (ai+1 > ai). 
 * E.g. if n=3 (123,124,125,……129,234,…..789)
 * 
 */

package javaclasses;

public class Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Numbers numbers = new Numbers();
		numbers.printNumbers(5);
	}

	public void printNumbers(int n) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		subPrint("", 0, n, a);
	}

	private void subPrint(String preFix, int startIndex, int numberCount,
			int[] a) {
		for (int i = startIndex; i < a.length; i++) {
			int digit = a[i];
			if (numberCount == 1) {
				System.out.println(preFix + digit);
			} else {
				subPrint(preFix + digit, digit, numberCount - 1, a);
			}
		}
	}
}
