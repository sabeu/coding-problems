package Recursion;

public class Palindrome {

	public static boolean isPalindrome(String s) {
		System.out.println(s);
		int length = s.length();
		if (length < 2) return true;
		else {
			if (s.charAt(0) != s.charAt(length-1))
				return false;
			else
				return isPalindrome(s.substring(1, length-1));
		}
	}
	
	public static void main(String[] args) {
		String[] stringArray = new String[3];
		stringArray[0] = "abba";
		stringArray[1] = "aba";
		stringArray[2] = "abcba";
		
		for (String s : stringArray) {
			System.out.println(isPalindrome(s));
		}
	}

}
