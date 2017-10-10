package CtCI.chapter1;
/*
 * 1. 8 Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call
 * to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class RotatedStringSubString {

	public static void main(String[] args) {
		String s1 = "herehellot";
		String s2 = "hellothere";
		System.out.println(isRotatedString(s1, s2));
	}
	

	public static boolean isRotatedString(String s1, String s2) {
	    if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) return false;
	    if (s2.length() != s1.length()) return false;
	    
	    // using contains instead of isSubstring
	    return (s1+s1).contains(s2);
	}
	

}
