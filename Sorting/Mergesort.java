package Sorting;
import java.util.Arrays;

public class Mergesort {
	/*
	 * Worst-case O(nlogn): O(logn) levels times O(n) per level
	 */
	public static void mergeSort(int[] A, int lower, int upper) {
		if (upper > lower) {			
			//System.out.println(lower + " " + upper);
			int mid = lower + (upper-lower)/2;
			
			mergeSort(A, lower, mid);
			mergeSort(A, mid+1, upper);
			//System.out.println(lower + " " + mid + " " + upper);
			merge(A, lower, mid, upper);
			return;
		}
	}
	
	private static void merge(int[] A, int lower, int mid, int upper) {
		int sizeA = mid - lower + 1;
		int sizeB = upper - mid;
		
		int[] arrA = new int[sizeA];
		int[] arrB = new int[sizeB];
		
		
		for (int i = 0; i < sizeA; i++) {
			arrA[i] = A[lower+i];
		}
		for (int j = 0; j < sizeB; j++) {
			arrB[j] = A[mid+1+j];
		}
		
		int k = 0, l = 0, t = lower;
		
		while(k < sizeA && l < sizeB) {
			if (arrA[k] <= arrB[l]) {
				A[t] = arrA[k];
				k++;
			} else {
				A[t] = arrB[l];
				l++;
			}
			t++;
		}
		
		// Copy remaining elements if any
		while (k < sizeA) {
            A[t] = arrA[k];
            k++;
            t++;
        }
         
        while (l < sizeB) {
            A[t] = arrB[l];
            l++;
            t++;
        }
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,6,4,6,7,5,9,11,2};
		int arrayLength = A.length-1;
		mergeSort(A, 0, arrayLength);
		System.out.println(Arrays.toString(A));

	}

}
