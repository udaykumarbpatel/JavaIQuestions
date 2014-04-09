package javaclasses;

public class MedianUnsorted {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, -2, 4, -4 };
		int len = arr.length;
		System.out.println("Median: \n" + median(arr, 0, len - 1, 0));
	}

	/* Median or rank of the number in the unsorted array */
	static int median(int arr[], int low, int high, int rank) {
		int pivot = low;
		int l = low;
		int h = high;
		if (l <= h) {
			while (l < h) {
				while (arr[l] <= arr[pivot])
					l++;
				while (arr[h] > arr[pivot])
					h--;

				if (l < h) {
					arr[l] = arr[l] + arr[h];
					arr[h] = arr[l] - arr[h];
					arr[l] = arr[l] - arr[h];
				}
			}

			if (pivot != h) {
				arr[pivot] = arr[pivot] + arr[h];
				arr[h] = arr[pivot] - arr[h];
				arr[pivot] = arr[pivot] - arr[h];
			}
		}

		if (rank < h)
			return median(arr, low, h - 1, rank);
		else if (rank > h)
			return median(arr, h, high, rank);
		else
			return arr[h];
	}
}
