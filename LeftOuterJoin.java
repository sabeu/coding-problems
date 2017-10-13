
import java.io.*;
import java.util.*;

/* 
	file_a and file_b are file path strings
	col_a and col_b are non-negative integers
	
	prints out a left_outer_join of two CSV files, with
	the specified 0-index columns as the join keys. For
	simplicity, assume that a match only happens 0 or 1
	times, and that the lines within each file have the
	same number of columns.  In terms of formatting, the 
	output should begin with the join key, then have the 
	non-join key columns of file_a and then the non-join 
	key columns of file_b. Output the correct number of 
	NULLs if there is no match in file_b.
	
	Example:
	
	file_a:
	a,1,q
	b,3,7
	c,2,t
	
	file_b:
	a,d,g,2
	j,p,4,1
	
	left_outer_join(file_a, 1, file_b, 3) -->
	1,a,q,j,p,4
	3,b,7,NULL,NULL,NULL
	2,c,t,a,d,g
	
	left_outer_join(file_a, 0, file_b, 0) -->
	a,1,q,d,g,2
	b,3,7,NULL,NULL,NULL
	c,2,t,NULL,NULL,NULL
*/


class LeftOuterJoin {
	static private void join_left(char[][] fileA, int col_a, char[][] fileB, int col_b) {
		if (fileA == null && fileB == null) return;
		if (col_a > fileA[0].length - 1 || col_b > fileB[0].length - 1) {
			System.out.println("Column index is out of range.");
			return;
		}

		int lengthA = fileA.length;
		int lengthB = fileB.length;

		// iterate over every row
		for (int j = 0; j < lengthA; j++) {
			int row = -1;
			char c = fileA[j][col_a];
			// first print out the character of the column A at row j
			System.out.print(c);
			
			// then print out the rest of the row's elements
			for (int k = 0; k < fileA[j].length; k++) {
				if (k != col_a) {
					System.out.print(", " + fileA[j][k]);
				}
			}
			
			// compare the element of row A with the all the elements in column B
			// if there is a common element, get the matching element's row index in file B
			// and break (because of the constraint that guarantees to have only one common element)
			for (int i = 0; i < lengthB; i++) {
				if (c == fileB[i][col_b]) {
					row = i;
					break;
				}
			}

			// lastly, print out the remaining elements in matching row of file B
			// otherwise print 'null'
			for (int t = 0; t < fileB[0].length; t++) {
				if (t != col_b) {
					if (row != -1)
						System.out.print(", " + fileB[row][t]);
					else
						System.out.print(", NULL");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] a = {
				{'a','1','q'},
				{'b','3','7'},
				{'c','2','t'}};
		char[][] b = {
				{'a','d','g','2'},
				{'j','p','4','1'}};
		
		join_left(a, 1, b, 3);
	}
}


