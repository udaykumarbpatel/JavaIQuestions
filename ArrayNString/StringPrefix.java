package javaclasses;
public class StringPrefix {

	public static void main(String[] args) {

		String[] input = { "apple", "appe", "apricot" };
		String prefix1 = input[0];
		int i = 0;
		while (i < input.length - 1) {
			String prefix = "";

			for (int j = 0; j < Math.min(input[i].length(),
					input[i + 1].length()); j++) {
				if (input[i].charAt(j) == input[i + 1].charAt(j)) {
					prefix = prefix + input[i].charAt(j);
				} else {
					continue;
				}
			}
			if (prefix.length() < prefix1.length())
				prefix1 = prefix;
			i++;
			System.out.println(prefix1);
		}
		System.out.println(prefix1);
	}
}
