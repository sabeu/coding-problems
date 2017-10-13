package Stack;
import java.util.*;

public class DecodeString {

	public static void main(String[] args) {
		String s = "z1[y]zzz2[abc]";  // zyzzzabcabc
		String s1 = "2[b3[a]]";   // baaabaaa
		String s2 = "3[a]2[bc]";  // aaabcbc
		String s3 = "3[a2[c]]";   // accaccacc
		String s4 = "2[abc]3[cd]ef"; // abcabccdcdcdef
		String s5 = "sd2[f2[e]g]i"; //sdfeegfeegi
		decodeString(s);

	}
	static String decodeString(String s) {
	    if (s.isEmpty()) return "";
	    int length = s.length();
	    Stack<Integer> numbersStack = new Stack<>();
	    Stack<String> lettersStack = new Stack<>();
	    
	    String str = "", ans = "", num = "";
	    
	    
	    for (int i = 0; i < length; i++) {
	        if (Character.isDigit(s.charAt(i))) {
	            num=num.concat(s.charAt(i)+"");
	        } else if (s.charAt(i) == '[') {
	            lettersStack.push(str);
	            str = "";
	            if (!num.isEmpty())
	                numbersStack.push(Integer.valueOf(num));
	            else
	                numbersStack.push(0);
	            num = "";
	        } else if (s.charAt(i) == ']') {
	            int number = numbersStack.pop();
	            while (number != 0) {
	                ans = ans.concat(str);
	                number--;
	            }
	            str = lettersStack.pop().concat(ans);
	            ans = "";
	        } else {
	            str = str.concat(String.valueOf(s.charAt(i)));
	        }
	    }
	    return str;
	}
}
