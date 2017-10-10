import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfTwoValues {
	final static int[] A = {5, 6, 7, 3, 8, 1, 9, 4, 4}; 
	final static int sum = 17;
	
	// this example for unique values in array
	// time O(n)
	// space O(n)
	public static void main(String[] args) {
		System.out.println(isSumOfTwoHash(A, sum));
		System.out.println(isSumOfTwoBrute(A, sum));
		System.out.println(isSumOfTwoSortSeach(A, sum));
		System.out.println(isSumOfTwoSortInward(A, sum));
	}
	
	
	/**
	 * This is a brute-force method: compares all possible pairs of
	 * elements to the 'sum'. Runs in O(n^2) time, and O(1) space. 
	 * @param A - array of int
	 * @param sum - target sum
	 * @return boolean - true if there are two integers that sum up to 'sum'
	 * 				   - false otherwise
	 */
	private static boolean isSumOfTwoBrute(int[] A, int sum) {
		int length = A.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (A[i] + A[j] == sum)
					return true;
			}
		}
		
		return false;
	}

	/**
	 * This method uses Hashtable, runs in O(n) time and O(n) space
	 * @param A - array of int
	 * @param sum - target sum
	 * @return boolean - true if there are two integers that sum up to 'sum'
	 * 				   - false otherwise
	 */
	private static boolean isSumOfTwoHash(int[] A, int sum) {
		Set<Integer> values = new HashSet<Integer>();
		for (int i : A) {
			if (values.contains(sum - i)) {
				return true;
			}
			values.add(i);
		}
		return false;
	}
	
	
	/**
	 * This method sorts the array A first, and iteratively searches for the
	 * second operand using binary search. Runs in O(nlogn): sorting - quick sort O(nlogn) +
	 * searching - n times O(logn) = O(nlogn). Space O(logn) <- because used Quicksort.
	 * Heapsort would take O(1) space only. 
	 * @param A - array of int
	 * @param sum - target sum
	 * @return boolean - true if there are two integers that sum up to 'sum'
	 * 				   - false otherwise
	 */
	private static boolean isSumOfTwoSortSeach(int[] B, int sum) {
		int[] A = Arrays.copyOf(B, B.length);
		Arrays.sort(A);
		int length = A.length;
		for (int i = 0; i < length; i++) {
			int j = Arrays.binarySearch(A, (sum - A[i]));
			if (j >= 0) {
				if ((j != i) ||
						(i > 0 && A[i-1] == A[i]) ||
						(i < length - 1 && A[i+1] == A[i]))
					return true;
			}
		}
		return false;
	}
	
	
	/**
	 * This method sorts the array first, and then using 2 pointers
	 * compares the sum of the leftmost and rightmost elements in the array
	 * to the target sum. If that sum is less than the target sum, the right
	 * pointer is moved inwards (increased), if the total sum is greater than the 
	 * target sum, the left pointer is moved inwards (decreased). Running time depends
	 * on the sorting algorithm, if used Radix sort, the time would be O(nlogU), where 
	 * U - is the largest element. Space takes O(logn) with Quicksort or Radix sort, and
	 * O(1) if used Heap sort.
	 * @param A - array of int
	 * @param sum - target sum
	 * @return boolean - true if there are two integers that sum up to 'sum'
	 * 				   - false otherwise
	 */
	private static boolean isSumOfTwoSortInward(int[] B, int sum) {
		int[] A = Arrays.copyOf(B, B.length);
		Arrays.sort(A);
		int l = 0, r = A.length - 1;
		while (l < r) {
			int total = A[l] + A[r];
			if (total == sum) return true;
			if (total < sum) l++; 
			if (total > sum) r--;
		}
		
		return false;
	}
}
