package Recursion;
import java.util.*;

/*
 * #8 Given a list of n distinct elements, write a function
 * that lists all permutations of that list
 * Running time: O(n!)
 * 
 * Also, solving with DFS is possible and iteratively
 */
public class Permutations {
	
	public static void main(String[] args) {
		String s= "abcde";
		List<String> list = getAllPermutations(s);
		System.out.println(list.size());
		System.out.println(list.toString());
	}

	private static List<String> getAllPermutations(String s) {
		List<String> list = new ArrayList<>();			
		
		if (s.length() == 1) {
			list.add(s);
			return list;
		}
		char lastChar = s.charAt(s.length()-1);
		
		list = addChar(lastChar, getAllPermutations(s.substring(0, s.length()-1)));
		
		return list;
	}
	
	private static List<String> addChar(char c, List<String> ls) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (String str: ls) {
			sb.append(str);
			for (int i = 0; i <= str.length(); i++) {
				sb.insert(i, c);
				list.add(sb.toString());
				sb.deleteCharAt(i);
			}
			sb.setLength(0);
		}
		return list;
	}

}
