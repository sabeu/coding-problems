package Recursion;

public class NonContinuousSubString {

	private static boolean isSubString(String s1, String s2) {
		
		
		return isSubStringRec(s1, s2);
	}
	
	private static boolean isSubStringRec(String s1, String s2) {
		if (s2.isEmpty())
			if(s1.isEmpty())
				return true;
			else
				return false;
		else
			if (s1.isEmpty())
				return true;
			else
				if(s1.charAt(0) == s2.charAt(0))
					return isSubStringRec(s1.substring(1), s2.substring(1));
				else
					return isSubStringRec(s1, s2.substring(1));
	}
	
	public static void main(String[] args) {
		String s1 = "car";
		String s2 = "cathactic";
		System.out.println(isSubString(s1, s2));

	}

}
