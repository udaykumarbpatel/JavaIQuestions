package javaclasses;

public class PalindromeDP {

	public static void main(String[] args) {
		String str = "cabbaabbacasdasdsdsdsdassadsadasdasadsadasda";
		System.out.println("String: " + str);

		findPalindromes(str, 1, 3);
	}

	public static void findPalindromes(String str, double mid, int minSize) {
		if (mid < str.length()) {
			check(str, (int) Math.floor(mid), (int) Math.ceil(mid), minSize);
			mid = mid + 0.5;
			findPalindromes(str, mid, minSize);
		}
	}

	public static void check(String str, int start, int end, int minSize) {
		if (start >= 0 && end < str.length()
				&& str.charAt(start) == str.charAt(end)) {
			if (end - start + 1 >= minSize) {
				System.out.println(str.substring(start, end + 1));
			}
			check(str, start - 1, end + 1, minSize);
		}
	}

}
