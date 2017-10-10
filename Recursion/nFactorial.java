package Recursion;

public class nFactorial {

	private static int nFact(int n) {
		if (n < 0) return -1;
		if (n == 0) return 1;
		return nFact(n-1) * n;
	}
	public static void main(String[] args) {
		int n = 30;
		System.out.println(nFact(n));
	}

}
