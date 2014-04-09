package javaclasses;

import java.util.HashSet;

public class DuplicatesString {
	public static void main(String[] args) {
		String str = "Uday Ptel";
		HashSet<Character> hstr = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			int j;
			for (j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					
				}
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (!hstr.contains(str.charAt(i)))
				hstr.add(str.charAt(i));
		}

		System.out.println(hstr.size() == str.length());
	}

}
