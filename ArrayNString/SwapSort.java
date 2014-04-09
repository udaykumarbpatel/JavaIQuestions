package javaclasses;
import java.util.Arrays;

public class SwapSort {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 8, 2, 5, 9, 3, 6, 4, 7, 15, 21, 12 };
		Arrays.sort(nums); // sort the array
		System.out.println(Arrays.toString(nums));
		int[] swapped = swap(nums); // call swap on nums array
		System.out.println(Arrays.toString(swapped)); // print result of swap
	}

	public static int[] swap(int[] arr) {
		int[] returnArr = new int[arr.length];
		returnArr[0] = arr[0];
		int arrCounter = 2;
		for (int i = 1; i < arr.length - 1; i++) {
			returnArr[i] = arr[arrCounter];
			if (i % 2 == 0) {
				arrCounter += 3;
			} else {
				arrCounter--;
			}
		}
		if (arr.length % 2 == 0) {
			returnArr[returnArr.length - 1] = arr[arr.length - 1];
		} else {
			returnArr[returnArr.length - 1] = arr[arr.length - 2];
		}
		return returnArr;
	}
}
