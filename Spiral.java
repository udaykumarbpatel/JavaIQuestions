package javaclasses;

public class Spiral {

	public static void main(String[] args) {
		char[][] matrix = { { 'i', 'l', 'o', 'v', 'e' },
				{ 'd', 'i', 'n', 't', 'e' }, { 'n', 'e', 'w', 'e', 'p' },
				{ 'a', 'i', 'v', 'r', 'i' }, { 'm', 'a', 'x', 'e', 'c' } };

		spiral(matrix);

	}
	
	

	

	static void spiral(char[][] mat) {
		int length = mat.length;
		int i = 0, j;
		int count = 0;
		while (i < mat.length / 2 + 1) {
			i = count;
			j = count;
			while (j < length) {
				System.out.print(mat[i][j++]);
			}
			j--;
			while (i < length - 1) {
				System.out.print(mat[++i][j]);
			}
			while (j > count) {
				System.out.print(mat[i][--j]);
			}
			while (i > count + 1) {
				System.out.print(mat[--i][j]);
			}
			count++;
			length--;

		}

	}

}
