package javaclasses;

public class DictionaryCharSet {

	public static void main(String[] args) {
		String[] dictionary = { "hello", "world", "is", "my", "first",
				"program" };
		String charset = "eiifrsst";
		dictionary(dictionary, charset.toCharArray());

	}

	public static void dictionary(String[] dictionary, char[] charset) {
		int len = charset.length;
		int[] arr = new int[256];
		int count = len, j, k, rep = len;

		for (int i = 0; i < len; i++) {
			arr[charset[i]]++;
		}

		do {
			rep = count;
			for (int i = 0; i < dictionary.length; i++) {
				if (arr[dictionary[i].charAt(0)] != 0) {
					for (j = 0; j < dictionary[i].length(); j++) {
						if (arr[dictionary[i].charAt(j)] != 0) {
							arr[dictionary[i].charAt(j)]--;
							count--;
						} else
							break;
					}
					if (j != dictionary[i].length()) {
						for (k = j - 1; k >= 0; k--) {
							arr[dictionary[i].charAt(k)]++;
						}
						count = len;
					}
					if (count == 0)
						break;
				}
			}
		} while (rep != count);

		if (count == 0)
			System.out.println("true");
		else
			System.out.println("false");

	}

}
