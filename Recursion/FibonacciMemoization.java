package Recursion;

public class FibonacciMemoization {

	public static void main(String[] args) {
		int n = 12;
		int[] A = new int[n+1];
		System.out.println(computeFibonacci(n, A));
	}

	private static int computeFibonacci(int n, int[] A) {
		if (n == 0 || n == 1)
			return n;
		
		int sum = A[n];
		if (sum == 0) {
			sum = computeFibonacci(n-2, A) + computeFibonacci(n-1, A); 
			A[n] = sum;
		}
		return sum;
	}

}
