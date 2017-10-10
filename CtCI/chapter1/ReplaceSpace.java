package CtCI.chapter1;
import java.util.Arrays;
/*
 * 1.5 Write a method to replace all spaces in a string with ‘%20’.
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		String s = "abc cd adabaf d!";
		System.out.println(replaceSpaces1(s));
		System.out.println(replaceSpaces2(s));
	}
	public static String replaceSpaces1(String s) {
	    int length = s.length();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < length; i++) {
	        char c = s.charAt(i);
	        if (c == ' ')
	            sb.append("%20");
	        else
	            sb.append(s.charAt(i));
	    }
	    
	    return sb.toString();
	}
	
	public static String replaceSpaces2(String s) {
	    int length = s.length();
	    char[] str = s.toCharArray();
	    int spaceCount =  0;
	    int j = 0;
	    for (char c : str) {
	        if (c == ' ') spaceCount++;
	    }
	    
	    char[] newStr = new char[spaceCount * 2 + length];
	    for (int i = 0; i < length; i++) {
	        if (str[i] == ' ') {
	            newStr[j] = '%';
	            newStr[j += 1] = '2';
	            newStr[j += 1] = '0';
	        }
	        else {
	            newStr[j] = str[i];
	        }
	        j++;
	    }
	    return String.valueOf(newStr);
	}


}
