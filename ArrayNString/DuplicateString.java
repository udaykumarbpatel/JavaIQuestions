package javaclasses;

public class DuplicateString {

	public static void main(String[] args) {
		String str1 = "uday";
		String str2 = "kumar";

		for (int i = 0; i < str1.length(); i++) {
			if (str2.contains(str1.charAt(i) + "")) {
				System.out.print(str1.charAt(i));
			}
		}

		String input = "a1b2c3d4e5f6g7h8i9j1k2l3m4";
		System.out.println("String before change = " + input);

		for (int i = 1; i < input.length() / 2 + 1; i++) {
			input = input.substring(0, i)
					+ input.substring(i + 1, input.length()) + input.charAt(i);
		}
		System.out.println("String after change = " + input);
	}

}
