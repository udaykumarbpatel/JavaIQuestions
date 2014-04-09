package javaclasses;

import java.util.ArrayList;

public class ArrayTranspose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] matrix = new int[5][];
		matrix[0] = new int[5];
		matrix[1] = new int[5];
		matrix[2] = new int[5];
		matrix[3] = new int[5];
		matrix[4] = new int[5];

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				matrix[i][j] = j;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("After the Changes");

		int[][] trans = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				for (int k = 0; k < 5; k++) {
					trans[k][j] = matrix[i][k];
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(trans[i][j] + " ");
			}
			System.out.println();
		}

//		ArrayList<Integer> arr = new ArrayList<Integer>();
//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (matrix[i][j] == 0) {
//					arr.add((i * 10 + j));
//				}
//			}
//			System.out.println();
//		}
//		System.out.println(arr);
//
//		if (arr.size() == 0) {
//			System.out.println("No Zero Elements");
//		} else {
//			for (int c = 0; c < arr.size(); c++) {
//				int row = (arr.get(c) - arr.get(c) % 10) / 10;
//				int col = arr.get(c) % 10;
//
//				for (int i = 0; i < 5; i++) {
//					matrix[row][i] = 0;
//					matrix[i][col] = 0;
//				}
//			}
//		}
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}
