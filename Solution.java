import java.io.*;
import java.util.*;

class Solution {
	/*
	Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] unsorted = new String[n];
    String temp;
    for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
        unsorted[unsorted_i] = in.next();
    }
	 * 
	 * */

    void solve(Scanner in, PrintWriter out) {
        String a[] = new String[in.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.next();
        }
        Arrays.sort(a, (left, right) -> {
            if (left.length() != right.length()) {
                return left.length() - right.length();
            } else {
                return left.compareTo(right);
            }
        });
        for (String s : a) {
            out.println(s);
        }
    }
    
    void run() {
        try (
            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out);
        ) {
            solve(in, out);
        }
    }

    public static void main(String args[]) {
        new Solution().run();
    }
}