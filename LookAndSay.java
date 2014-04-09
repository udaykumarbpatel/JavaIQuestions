package javaclasses;

import java.util.Scanner;

public class LookAndSay {

	public static void lookAndSay(String s) {

		System.out.println(s);
		s = "1" + s;
		System.out.println(s);

		StringBuilder output = new StringBuilder();
		for (int x = 2; x < 10; x++) {
			int count = 1;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					count++;
					// if this is the last iteration
					if (i == s.length() - 2) {
						// append the count and the character to the output
						output.append("" + count + s.charAt(i));
					}
				} else {
					// if character is not same as next character append the
					// count and the character
					output.append("" + count + s.charAt(i));
					// reset the count
					count = 1;
					// if this is the last iteration
					if (i == s.length() - 2) {// this means last character is
												// unique, append this
												// information to output
						output.append("1" + s.charAt(i + 1));
					}
				}
			}

			// print output, set string to last output, and reset output
			System.out.println(output.toString());
			s = output.toString();
			output = new StringBuilder();
		}
	}

	public static void main(String[] args) // throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String s = sc.nextLine();
		sc.close();
		lookAndSay(s);
	}

}