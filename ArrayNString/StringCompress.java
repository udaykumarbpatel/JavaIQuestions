package javaclasses;

public class StringCompress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compress("FOOOOOOFIIIIGHTTTTTEEEEERRRRRR");

	}

	public static String compress(String word) {
		char lastLetter = 0;
		int lastLetterCounter = 0;
		for (int i = 0; i < word.length(); i++) {
			char tempLetter = word.charAt(i);
			if (tempLetter == lastLetter) {
				if (++lastLetterCounter >= 2) {
					word = word
							.substring(0, lastLetterCounter == 2 ? i : i - 1)
							+ lastLetterCounter + word.substring(i + 1);
				}
			} else {
				lastLetterCounter = 1;
			}
			lastLetter = tempLetter;
		}
		System.out.println(word);
		return word;
	}

}
