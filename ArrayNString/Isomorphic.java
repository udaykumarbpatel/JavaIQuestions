package javaclasses;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

	public static boolean isIsomorphic1(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		else if (s1.length() == 1)
			return true;
		else {
			Map<Character, Integer> map1 = new HashMap<Character, Integer>();
			StringBuffer encodingString1 = new StringBuffer();
			
			Map<Character, Integer> map2 = new HashMap<Character, Integer>();
			StringBuffer encodingString2 = new StringBuffer();
			
			for (int i = 0; i < s1.length(); i++) {
				if (!map1.containsKey(s1.charAt(i))) {
					map1.put(s1.charAt(i), i);
				}
				encodingString1.append(map1.get(s1.charAt(i)));

				if (!map2.containsKey(s2.charAt(i))) {
					map2.put(s2.charAt(i), i);
				}
				encodingString2.append(map2.get(s2.charAt(i)));
			}
			System.out.println(encodingString1);
			System.out.println(encodingString2);
			return encodingString1.toString()
					.equals(encodingString2.toString());
		}
	}

	public static void main(String[] args) {

		String s1 = "aab";
		String s2 = "caa";
		System.out.println(isIsomorphic1(s1, s2));
		
		
		
		
	}

}
