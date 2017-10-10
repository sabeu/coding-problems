package Recursion;

public class FibonacciString {

	/*
	 * #40 The Fibonacci strings are a series of recursively­ defined strings. F₀ is the string a, F₁ is
	 * the string bc, and Fn₊₂ is the concatenation of Fn and Fn₊₁. For example, F₂ is abc, F₃ is
	 * bcabc, F₄ is abcbcabc, etc. Given a number n and an index k, return the kth character of
	 * the string Fn.
	 */
	public static void main(String[] args) {
		int n = 2;
		int k = 2;
		System.out.println(getCharIndexInFibonacci(n, k));
	}

	private static char getCharIndexInFibonacci(int n, int k) {
		if (nLength(n) <= (k) || k < 0)
			throw new IndexOutOfBoundsException();
		
		String s = getCharIndexInFibonacciRec(n);
		System.out.println(s);
		return s.charAt(k);
	}
	private static int nLength(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 2;
		else return nLength(n-1) + nLength(n-2);
	}

	private static String getCharIndexInFibonacciRec(int n) {
		if (n == 0)
			return "a";
		if (n == 1)
			return "bc";
		else
			return getCharIndexInFibonacciRec(n-2) + getCharIndexInFibonacciRec(n-1);
	}
	
}
