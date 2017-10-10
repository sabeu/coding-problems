import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
	
	/**
	 * This solution uses Selection sort, which stops sorting after kth
	 * element is found. Runs in O(n^2), space O(1)
	 * @param A - array
	 * @param k - kth element
	 * @return int - smallest kth element in array A
	 */
	public static int kthSmallestBrute(int[] A, int k) {
		if (k < 0 || k > A.length)
			throw new IllegalArgumentException();
		
		selectionSort(A, k);
		
		return A[k-1];
	}
	
	private static void selectionSort(int[] A, int k) {
		int length = A.length;
		for (int i = 0; i < k; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (A[min] > A[j]) {
					min = j;
				}
			}
			if (min != i)
				swap(A, min, i);
		}
	}
	
	private static void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	
	/**
	 * This method sorts the entire array with Quick sort, then
	 * returns kth element. Runs in O(nlogn) - because of Quick Sort,
	 * space - O(logn) - because of Quick sort.
	 * @param A - array
	 * @param k - kth element
	 * @return int - smallest kth element in array A
	 */
	public static int kthSmallestQuickSort(int[] A, int k) {
		if (k < 0 || k > A.length)
			throw new IllegalArgumentException();
		// uses QuickSort
		Arrays.sort(A);
		
		return A[k-1];
	}
	
	/** 
	 * This method uses Max-Heap of size 'k' for tracking the k smallest
	 * elements in a heap. Whenever an element smaller than the root in the 
	 * heap is found, that root is removed and the new smallest element is pushed
	 * into the heap. Runs in O(nlogk), where k is the size of the heap and
	 * 'remove/add' to heap operations take O(logk).
	 * Space - O(k) - for heap of size k. 
	 * @param A - array
	 * @param k - kth element
	 * @return int - smallest kth element in array A
	 */
	public static int kthSmallestHeap(int[] A, int k) {
		if (k < 0 || k > A.length)
			throw new IllegalArgumentException();
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		
		for (int i = 0; i < k; i++) {
			heap.add(A[i]);
		}
		
		int length = A.length;
		
		for (int j = k; j < length; j++) {
			if (A[j] < heap.peek()) {
				heap.remove();
				heap.add(A[j]);
				
			}
		}
		
		return heap.peek();
	}
	
	/**
	 * This method uses partially sorted QuickSort. We split array according to 
	 * randomly chosen pivot, all elements larger than pivot moved to the right, and
	 * the rest moved to the left from the pivot. Depending on k, we proceed to the relevant
	 * half of the array and check if the pivot equals to k, if not, we continue recursively
	 * dividing the array further. 
	 * @param A - array
	 * @param k - kth element
	 * @return int - smallest kth element in array A
	 */
	public static int kthSmallestPartialQuickSort(int[] A, int k) {
		// TODO Add code for partial QuickSort
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,6,7,9,10,5,4};
		int[] B = Arrays.copyOf(A, A.length);
		int[] C = Arrays.copyOf(A, A.length);
		int k = 7;
		
		System.out.println(kthSmallestBrute(A, k));
		System.out.println(kthSmallestQuickSort(B, k)); 
		System.out.println(kthSmallestHeap(C, k));

	}

}
