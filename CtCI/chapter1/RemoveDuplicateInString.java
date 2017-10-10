package CtCI.chapter1;
import java.util.Arrays;

/*
 * 1.3 CCI Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer. NOTE: One or two additional variables are fine.
 * An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 */
public class RemoveDuplicateInString {

	public static void main(String[] args) {
		String s = "aaaaa";
		System.out.println(removeDuplicates(s));
		removeDups(s.toCharArray());
	}

	
	/**
	 * Running time O(n), uses additional buffer
	 * @param s the string
	 * @return the new string without duplicate characters
	 */
	private static String removeDuplicates(String s) {
		try {
			if (s.isEmpty()) {
				System.out.println("String is empty");
				return "";
			}
				
			StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (sb.indexOf(Character.toString(c)) == -1) {
					sb.append(c);
				}
			}
			return sb.toString();
		} catch (NullPointerException e) {
			System.out.println("String is null!");
			return null;
		}
	}
	
	
	/**
	 * Running time O(n^2), without additional data structure,
	 * modification is in-place
	 * @param str the char array
	 */
	private static void removeDups(char[] str) {
		
		if (str == null) return;

		int len = str.length;
		if (len < 2) return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) {
					str[tail] = 0;
				}
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		
		System.out.println(Arrays.toString(str));
	}

}
