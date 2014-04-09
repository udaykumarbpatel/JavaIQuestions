package javaclasses;

public class IncrementString {

	public static void main(String[] args) {
		int input = 987;

		System.out.println("Next Number for " + input + " is "
				+ nextInteger(input));
	}

	private static int nextInteger(int input) {

		// Step1 normalize the number for 9
		input = normalizeFor9(input);

		// Step2: Now get the first digit of the updated number to form
		// increasing sequence
		int firstDigit = getFirstDigitOfInput(input);
		int sizeOfInput = String.valueOf(input).length();

		/*
		 * It may happen that while forming next number of same size, digit may
		 * spill over to 10. So get the next larger number which wont spill over
		 * to 10. if the size of the input is going to spill over into 10. The
		 * only possible number in that case is the number 1 followed by the
		 * size of the input example if the input is 800, the closes number is
		 * going to be 1000
		 */
		if (firstDigit + sizeOfInput > 9) {
			//
			input = (int) Math.pow(10, String.valueOf(input).length());
			firstDigit = getFirstDigitOfInput(input);
			sizeOfInput = String.valueOf(input).length();
		}

		StringBuffer finalNumber = new StringBuffer();
		finalNumber.append(firstDigit);
		while (sizeOfInput > finalNumber.toString().length()) {
			finalNumber.append(++firstDigit);
		}

		return Integer.valueOf(finalNumber.toString());
	}

	// Get the first digit of the given input
	private static int getFirstDigitOfInput(int input) {
		int firstDigit = input
				/ (int) Math.pow(10, String.valueOf(input).length() - 1);
		return firstDigit;
	}

	/*
	 * Start from the right most digit if number has 9 in it, then increment the
	 * input by the place value of 9. For example on 79, 9 is at position 0 so
	 * increment by 1 in 192, 9 is at ten position (position 1), so increment by
	 * 192+(10-92%10) in 933, 9 is at hundred position (position 2), so
	 * increment by 933+(100-933%100) in 19147, 9 is at thousand position
	 * (position 3) so increment by 19147+(1000-19147%1000)
	 */
	private static int normalizeFor9(int input) {
		while (findPosition(input, 9) != -1) {
			int position = findPosition(input, 9);
			if (position == 0) {
				input++;
			} else {
				input = input
						+ ((int) (Math.pow(10, position)) - input
								% (int) Math.pow(10, position));
			}
		}
		return input;
	}

	// Return the position of 9 in the input. If 9 does not exists, return -1.
	private static int findPosition(int input, int digit) {
		int position = 0;
		while (input != 0) {
			if (input % 10 == digit) {
				return position;
			} else {
				input = input / 10;
				position++;
			}
		}
		return -1;
	}
}