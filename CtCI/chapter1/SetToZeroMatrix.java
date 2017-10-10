package CtCI.chapter1;
/*
 * 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column is set to 0. The CtCI book has a better solution for space O(M+N) and time O(M*N).
 */
public class SetToZeroMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1, 1, 1, 1, 1, 1},
				{2, 2, 2, 2, 2, 2},
				{3, 3, 0, 3, 3, 3},
				{4, 4, 4, 4, 4, 4},
				{5, 5, 5, 5, 5, 5},
				{6, 6, 6, 6, 6, 6}};
		setToZero(matrix);
		
		// Should not call printMatrix this way, but too lazy to move it to a non-default package
		RotateMatrix.printMatrix(matrix);
	}
	
	/**
	 * This method uses additional array of size (M*N)*2 for storing 0 indexes,
	 * and at the end sets all rows and columns to 0 in-place by calling a setAllZero helper method
	 * Running time worst-case (all zeros) = O((M*N)*(M + N)), best-case (no zeros) = O(M*N)
	 * Space O(M*N)
	 * @param matrix to be set to Zero
	 */
	public static void setToZero(int[][] matrix) {
	    int n = matrix[0].length;
	    int m = matrix.length;
	    int[][] zeroIndexes = new int[n*m][2]; // space O(M*N)
	    int k = 0;
	    
	    // Running time = O(M*N) or 
	    // linear if the input is the number of elements in the matrix
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (matrix[i][j] == 0) {
	            	zeroIndexes[k][0] = i;
	            	zeroIndexes[k][1] = j;
	            	k++;
	            }
	        }
	    };
	    // Running time = Number of '0' indexes * ((1 row = M) + (1 column = N)) = O((M*N)*(M + N))
	    setAllZero(matrix, zeroIndexes);
	}

	/**
	 * This is a helper method that iterates over the indexes array
	 * and sets rows and columns to zero. Whenever the next row is 0 0, the
	 * cycle is terminated because the rest of the rows all 0 0.
	 * @param matrix
	 * @param zeroIndexes
	 */
	private static void setAllZero(int[][] matrix, int[][] zeroIndexes) {
	    int n = matrix[0].length;
	    int m = matrix.length;
	    int zeroIndexesLength = zeroIndexes.length;
	    
	    for (int k = 0; k < zeroIndexesLength; k++) {
	    	if (zeroIndexes[k][0] == 0 && zeroIndexes[k][1] == 0)
	    		break;
	    	for (int i = 0; i < m; i++) {
	    		matrix[i][zeroIndexes[k][0]] = 0;
	    	}
	    	for (int j = 0; j < n; j++) {
	    		matrix[zeroIndexes[k][1]][j] = 0;
	    	}
	    }
	}
	

}
