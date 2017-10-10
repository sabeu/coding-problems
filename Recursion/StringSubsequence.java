package Recursion;

public class StringSubsequence {

	private static boolean isSubString(String s1, String s2) {
		return isSubStringRec(s1, s2, 0);
	}
	
	private static boolean isSubStringRec(String s1, String s2, int index) {
		int length = s1.length();
		
		if (index + length == s2.length()) {
			if (s2.substring(index).equals(s1))
				return true;
			else
				return false;
		}
		if (s2.substring(index, index + length).equals(s1))
			return true;
		else
			return isSubStringRec(s1, s2, index+1);
	}
	
	public static void main(String[] args) {
		String s1 = "act";
		String s2 = "cathactic";
		System.out.println(isSubString(s1, s2));

	}

}
