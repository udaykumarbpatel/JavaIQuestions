package javaclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestWord {

	public static void main(String args[]) {
		

	}

	public String getLongest(Set<String> dict, String letters) {
		String result = "";
		for (String s : dict)
			if (s.length() > result.length() && isWordOfLetters(s, letters))
				result = s;
		return result.length() == 0 ? null : result;
	}

	private boolean isWordOfLetters(String s, String letters) {
		Map<Character, Integer> occ = new HashMap<Character, Integer>();
		for (char c : s.toCharArray())
			if (!occ.containsKey(c))
				occ.put(c, 1);
			else
				occ.put(c, occ.get(c) + 1);
		for (char c : letters.toCharArray())
			if (occ.containsKey(c))
				occ.put(c, occ.get(c) - 1);
		for (int i : occ.values())
			if (i > 0)
				return false;
		return true;
	}

}
