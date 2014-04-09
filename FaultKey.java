package javaclasses;

public class FaultKey {

	public static void main(String[] args) {

		System.out.println(isMatch("164", "18864"));

	}

	public static boolean isMatch(String input, String expected) {
		if (input == "" && expected == "")
			return true;
		if (input.length() > expected.length())
			return false;
		char missed = 0;
		int i = 0;
		int j = 0;
		while (i < input.length()) {
			if (input.charAt(i) == expected.charAt(j)) {
				i++;
				j++;
			} else {
				if (missed != 0 && expected.charAt(j) != missed)
					return false;
				else {
					missed = expected.charAt(j);
					for (int k = 0; k <= i; k++) {
						if (input.charAt(k) == missed)
							return false;
					}
				}
				j++;
			}
		}
		if (j == expected.length())
			return true;
		else {
			for (int k = j; k < expected.length(); k++) {
				if (expected.charAt(k) != missed)
					return false;
			}
			return true;
		}
	}

}
