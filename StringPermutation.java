package javaclasses;

public class StringPermutation {
	private static void print(String res, String digits, int n) {
		if (n == 0)
			System.out.println(res);

		for (int i = 0; i < digits.length(); ++i) {
			print(res + digits.charAt(i),
					digits.replace(String.valueOf(digits.charAt(i)), ""), n - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("", "0123456789", 3);
	}
}
