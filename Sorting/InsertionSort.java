package Sorting;
import java.util.Arrays;

public class InsertionSort {

	public void insertionSort(int[] A) {
		int length = A.length;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] < A[j])
					insert(A, i, j);
			}
		}
	}
	
	private void insert(int[] A, int i, int j) {
		int tmp = A[i];
		int k;
		for (k = i-1; k >= j; k--) {
			A[k+1] = A[k];
		}
		A[j] = tmp;
		//System.out.println(Arrays.toString(A));
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,6,7,9,10,5,4};
		InsertionSort sort = new InsertionSort();
		sort.insertionSort(A);
		System.out.println(Arrays.toString(A));
	}

}
