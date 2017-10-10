package CtCI.chapter1;
/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 1, 1, 1, 1, 1},
				{2, 2, 2, 2, 2, 2},
				{3, 3, 3, 3, 3, 3},
				{4, 4, 4, 4, 4, 4},
				{5, 5, 5, 5, 5, 5},
				{6, 6, 6, 6, 6, 6}};
		printMatrix(matrix);
		rotateInPlace(matrix);
		printMatrix(matrix);
		//printMatrix(rotate(matrix));
	}
	
	// assuming given matrix is NxN and not null
	
	/**
	 * Rotate NxN matrix to 90 degrees right,
	 * not in place, time O(n) where n is the number of pixels in the picture, space O(n^2)
	 * @param matrix to rotate
	 * @return newMatrix - new rotated matrix
	 */
	public static int[][] rotate(int[][] matrix) {
	    int size = matrix[0].length;
	    int[][] newMatrix = new int[size][size];
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	            newMatrix[j][size - i - 1] = matrix[i][j];
	        }
	    }
	    return newMatrix;
	}
	

	/**
	 * Rotate NxN matrix to 90 degrees right,
	 * time O(n) where n is the number of pixels in the picture, space O(1)
	 * @param matrix to rotate
	 */
	public static void rotateInPlace(int[][] matrix) {
	    int size = matrix[0].length;
	    int tmp = 0;
	    
	    // cycle through the outermost layers (all 4 sides)
	    for (int i = 0; i < size / 2; i++) {
	        int length = size - i - 1;
	        // cycle through the numbers in array's outermost length
	        for (int j = i; j < length; j++) {
	        	int innerLength = size - j - 1;
	            // get the top element
	        	tmp = matrix[i][j];
	            // move to top from left
	            matrix[i][j] = matrix[innerLength][i];
	            // move to left from bottom
	            matrix[innerLength][i] = matrix[length][innerLength];
	            // move to bottom from right
	            matrix[length][innerLength] = matrix[j][length];
	            // move to right from top
	            matrix[j][length] = tmp;
	        }
	    }
	}


	
	public static void printMatrix(int[][] matrix) {
		int n = matrix[0].length;
		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
