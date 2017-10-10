package CtCI.chapter1;
import java.util.HashSet;
/*
 * 1.1 Implement an algorithm to determine if a string has all unique characters. What if you
 * can not use additional data structures?
 */
public class UniqueCharacters {

	public static void main(String[] args) {
		String s = "abcdes";
		System.out.println(isUnique(s));
		System.out.println(isUniqueWithoutDS(s));
	}
	/*
	 * Using additional data structure
	 */
	private static boolean isUnique(String s) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i)))
				return false;
			else
				set.add(s.charAt(i));
		}
		return true;
	}
	
	/*
	 * Without using additional data structure
	 */
	private static boolean isUniqueWithoutDS(String s) {
		int checker = 0;
		int length = s.length();
		
		for (int i = 0; i < length; i++) {
			int bit = s.charAt(i) - 'a';
			
			if((checker & (1<<bit)) > 0)
				return false;
			checker = checker | (1<<bit);
			System.out.println(checker);
		}
		
		return true;
	}

}
