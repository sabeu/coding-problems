import java.io.*;
import java.util.*;



public class Decompression {
	static void solve(String compressed) {
		if(compressed.isEmpty()) return;
		
		String c = "sdfa";
		for(int i=0;i<6;i++) {
			System.out.println(c);
			i = i + 2;
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String compressed = in.next();
		//System.out.println(compressed);
		solve(compressed);
		
	}

}
