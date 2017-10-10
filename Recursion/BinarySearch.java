package Recursion;
public class BinarySearch {
	/* Given a sorted array of integers, return the index
	 * of the given key. Return -1 if not found.
	 * time O(log(n))
	 * space O(log(n))
	 */
	public static void main(String[] args) {
		int[] A = {5, 6, 7, 1, 8, 2, 9, 3, 4};
		int key = 9;
		System.out.println(binarySearch(A, key));

	}
	
	static int binarySearch(int[] A, int key) {
		int low = 0;
		int high = A.length-1;
		return binarySearchRec(A, key, low, high);
	}
	
	static int binarySearchRec(int[] A, int key, int low, int high) {
		if (low > high) return -1;

		int mid = low + (high - low)/2;
		//System.out.println(A[mid] + " " + low + " " + high);
		if (A[mid] == key) {
			return mid;
		} else if (A[mid] < key) {
			return binarySearchRec(A, key, mid + 1, high);
		} else {
			return binarySearchRec(A, key, low, mid - 1);
		}
	}
}
