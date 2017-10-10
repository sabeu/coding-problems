package CtCI.chapter1;
import java.util.Arrays;

/*
 * 1.4 CCI Write a method to decide if two strings are anagrams or not.
 * Assuming the strings contain only letters (alpha-string) (no numbers or symbols or spaces).
 * Running time O(n), space O(alphabet size*2)
 */
public class Anagrams {

	public static void main(String[] args) {
		String s1 = "sdtabdc";
		String s2 = "dabtsdc";
		System.out.println(isAnagram(s1, s2));
	}

	private static boolean isAnagram(String s1, String s2) {
		if (s2.isEmpty() || s1.isEmpty()) return false;
		if (s2 == null || s1 == null) return false;

		int length1 = s1.length();
		int length2 = s2.length();
		if (length1 != length2) return false;

		int[] a1 = new int[26]; // space O(Alphabet size)
		int[] a2 = new int[26];// space O(Alphabet size)
		
		for (int i = 0; i < length1; i++) { //time O(n)
			a1[(s1.charAt(i) - 'a')] += 1;
			a2[s2.charAt(i) - 'a'] += 1;
		}
		System.out.println(Arrays.toString(a2));
		System.out.println(Arrays.toString(a1));
		
		if (Arrays.equals(a1, a2)) // O(n)
			return true;
		
		return false;
	}
}


