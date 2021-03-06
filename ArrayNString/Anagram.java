package javaclasses;

import java.util.Arrays;

public class Anagram {
	public static boolean isAnagram(String s1, String s2) {

		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String sc1 = new String(c1);
		String sc2 = new String(c2);
		return sc1.equals(sc2);
	}

	public void func(String a, String b) {
		if (0 == a.length() || 0 == b.length()) {
			System.out.println("Null strings passed");
			return;
		}
		if (a.length() > b.length()) {
			System.out.println("Error check length");
			return;
		}
		int n = a.length();
		int max = b.length();
		int i;
		boolean flag = false;
		String tmp;
		for (i = 0; i < max; i++) {
			tmp = "";
			if (n > max)
				break;
			tmp = b.substring(i, n);
			flag = isAnagram(a, tmp);
			n++;
			if (flag == true)
				break;
		}
		if (flag)
			// System.out.println("\nFound at(starting at): " + i + " ends at: "
			// + (n - 2));
			System.out.println("Found");
		else
			System.out.println("Not found");
	}

	public static void main(String args[]) {
		Anagram z = new Anagram();
		String a = "xyz".toLowerCase();
		String b = "afdgZxyksldfm".toLowerCase();
		z.func(a, b);

	}

}