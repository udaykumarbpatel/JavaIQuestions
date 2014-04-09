package javaclasses;
/* Give a N*N matrix, print it out diagonally. 
   Follow up, if it is a M*N matrix, how to print it out.  */


public class DiagonalArray {
	public static void printAll(int[][] arr) {
		for (int x = 0; x < arr[0].length; ++x) {
			printOne(arr, x, 0);
		}
		for (int y = 1; y < arr.length; ++y) {
			printOne(arr, arr[0].length - 1, y);
		}
	}

	public static void printOne(int[][] arr, int x, int y) {
		while (x >= 0 && y < arr.length) {
			System.out.print(arr[y++][x--] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 4 }, { 3, 5, 7 }, { 6, 8, 9 } };
		printAll(arr);
		System.out.println();
		int[][] arr1 = { { 1, 2, 4 }, { 3, 5, 7 }, { 6, 8, 10 }, { 9, 11, 12 } };
		printAll(arr1);
		System.out.println();
		int[][] arr2 = { { 1, 2, 4, 7 }, { 3, 5, 8, 10 }, { 6, 9, 11, 12 } };
		printAll(arr2);
		System.out.println();
	}
}
