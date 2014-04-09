package javaclasses;

import java.util.Arrays;

public class AnagramArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] str = { "dog", "god", "dad", "add" };

		for (int i = 0; i < str.length; i++) {
			for (int j = i; j < str.length; j++) {
				if (isAnagram(str[i], str[j]) && i != j) {
					str[i] = str[i] + "," + str[j];
					str[j] = null;
				}
			}
		}
		
		for(int i=0; i<str.length;i++)
		{
			if(str[i] != null)
				System.out.println(str[i]);
		}
		
//		reversevowel("united states");
		
	}
	
	
	
	

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

}
