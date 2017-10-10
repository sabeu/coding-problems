package Recursion;
import java.util.Arrays;
/*
 * #38 A rotated array is an array formed by taking a sorted array, splitting it into two pieces,
 * then interchanging the order of those pieces. For example, the array [6, 7, 9, 0, 1, 2, 3, 4] is
 * a rotated array, as is [0, 1, 2, 3] (to see why it's rotated, split the array [0, 1, 2, 3] into the
 * pieces [6, 7, 9] and [0, 1, 2, 3], then interchange their order). Design an efficient algorithm that,
 * given a rotated array and a key k, determines whether k is present in the array.
 * 
 * This algorithm works only if array contains distinct elements, i.e. no duplicates.
 * Solution: split array into 2 halves, if k is in sorted half -> use Binary Search,
 * if k is not in sorted part, recurse. It's possible that 2 halves are sorted, in this case determine
 * within which half k may be, and continue. 
 * Running time: O(logn)
 */
public class KInRotatedArray {

	public static void main(String[] args) {
		int[] A = {4,5,6,7,8,9,0,1,2,3};
		int k = 3;
		System.out.println(isKeyInArray(A, k));
	}

	private static boolean isKeyInArray(int[] A, int k) {
		int length = A.length;
		int med = length/2 - 1;
		int index = -1;
		boolean result = false;
		
		if (A[med] == k)
			return true;
		
		if ((A[0] < A[med] && k <= A[med] && k >= A[0])) {
			System.out.println("in left binary search");
			index = Arrays.binarySearch(Arrays.copyOfRange(A, 0, med+1), k);			
		} else if (A[med+1] < A[length-1] && k <= A[length-1] && k >= A[med+1]) {
			System.out.println("in right binary search");
			index = Arrays.binarySearch(Arrays.copyOfRange(A, med+1, length), k);
		}
		else {
			if (A[0] > A[med] && (k > A[length-1] || k < A[med+1])) {
				System.out.println("in left D&C: " + 0 + " " + med);
				result = isKeyInArray(Arrays.copyOfRange(A, 0, med+1), k);
			} else if (A[med+1] > A[length-1] && (k > A[med] || k < A[0])) {
				System.out.println("in right D&C: " + (med + 1) + " " + (length-1));
				result = isKeyInArray(Arrays.copyOfRange(A, med+1, length), k);
			}
		}
		if (index > -1 || result)
			return true;
		return false;
	}
}
