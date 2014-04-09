package javaclasses;

public class ReplaceSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Uday Pa te l";

		StringBuffer new_str = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				System.out.println("Space");
				new_str.append("%20");
			} else {
				new_str.append(str.charAt(i));
			}
		}
		System.out.println(new_str);

	}

}
