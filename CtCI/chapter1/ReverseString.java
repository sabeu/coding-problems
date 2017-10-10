package CtCI.chapter1;
/*
 * 1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
 * five characters, including the null character.)
 */
public class ReverseString {

	private static void printReverseString(String s) {
		int index = 0;
		printRec(s, index);
	}
	
	private static void printRec(String s, int index) {
		if(index == s.length() - 1) {
			System.out.print(s.charAt(index));
			return;
		}
		printRec(s, index+1);
		System.out.print(s.charAt(index));
	}
	
	public static void main(String[] args) {
		String s = "star";
		printReverseString(s);
	}

}
