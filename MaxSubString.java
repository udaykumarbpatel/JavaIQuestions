package javaclasses;

public class MaxSubString {

	public static void main(String[] args) {
		int[] array = { 1, 7, 6, 3, 5, 8, 9 };
		int desiredSum = 16;
		findSubstringForAddingNumber(array, desiredSum);
	}

	public static void findSubstringForAddingNumber(int[] array, int desiredSum) {
		int index = 0, sum = 0, startIndex = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum == desiredSum) {
				index++;
				System.out.println((startIndex + 1) + "----" + (index + 1)
						+ "\t " + sum);
				// break;
			} else if (sum < desiredSum) {
				index++;
			} else {
				i = startIndex;
				startIndex++;
				index = i;
				sum = 0;
			}
		}
	}

}
