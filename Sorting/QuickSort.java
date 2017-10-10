package Sorting;
import java.util.Arrays;

public class QuickSort {
	/*
	 * Worst-case O(n^2), best-case O(nlogn): O(logn) - levels times O(n) operations per level
	 * It's in-place, fast (randomized pivot), but not stable.
	 */
	static void quickSort(int[] A, int lower, int upper) {
		if ((upper - lower) <= 1) return;
		
		// 1 - pick a pivot
		//int pivot_index = lower + (upper - lower)/2; // better use random
		int pivot_index = (int) (Math.random() * (upper-lower) + lower);
		
		//2 - divide the array
		int mid = partition(A, lower, pivot_index, upper);
		
		// 3 - recursively sort both parts
		quickSort(A, lower, mid);
		quickSort(A, mid + 1, upper);
		return;
	}
	
	private static int partition(int[] A, int lower, int pivot_index, int upper) {
		int pivot = A[pivot_index];
		swap(A, lower, pivot_index);
		int left = lower + 1;
		int right = upper;
		while(left < right) {
			if (A[left] <= pivot){
				left++;
			} else {
				swap(A, left, right - 1);
				right--;
			}
		}
		swap(A, lower, left - 1);
		return left - 1;
	}
	
	private static void swap(int[] A, int left, int right) {
		int tmp = A[left];
		A[left] = A[right];
		A[right] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,6,4,6,7,5,9,11,2};
		int arrayLength = A.length;
		quickSort(A, 0, arrayLength);
		System.out.println(Arrays.toString(A));
	}

}
