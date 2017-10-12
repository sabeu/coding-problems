import java.util.HashSet;

public class Sudoku {

	public static void main(String[] args) {
		// true
		char[][] gridTrue = new char[][]{
			{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
			{'.', '.', '6', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '1', '.', '.', '.', '.', '.', '.'},
			{'.', '6', '7', '.', '.', '.', '.', '.', '9'},
			{'.', '.', '.', '.', '.', '.', '8', '1', '.'},
			{'.', '3', '.', '.', '.', '.', '.', '.', '6'},
			{'.', '.', '.', '.', '.', '7', '.', '.', '.'},
			{'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
		
		// false
		char[][] gridFalse = new char[][]{
			{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
			{'.', '.', '.', '.', '6', '.', '.', '.', '.'},
			{'7', '1', '.', '.', '7', '5', '.', '.', '.'},
			{'.', '7', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '8', '3', '.', '.', '.'},
			{'.', '.', '8', '.', '.', '7', '.', '6', '.'},
			{'.', '.', '.', '.', '.', '2', '.', '.', '.'},
			{'.', '1', '.', '2', '.', '.', '.', '.', '.'},
			{'.', '2', '.', '.', '3', '.', '.', '.', '.'}};	
			
		sudoku(gridTrue);

	}
	
	// checks whether a given grid is a valid sudoku grid 
	static boolean sudoku(char[][] grid) {
	    return (isColumn(grid) && isRow(grid) && isSquare(grid));
	}
	
	private static boolean isColumn(char[][] grid) {
	    HashSet<Character> set = new HashSet<>();
	    int rowLength = grid[0].length;
	    int columnLength = grid.length;
	    for (int i = 0; i < rowLength; i++) {
	        for (int j = 0; j < columnLength; j++) {
	            char c = grid[j][i];
	            if (c != '.') {
	                if (!set.contains(c))
	                    set.add(c);
	                else
	                    return false;
	            }
	        }
	        set.clear();
	    }
	    return true;
	}
	
	private static boolean isRow(char[][] grid) {
	    HashSet<Character> set = new HashSet<>();
	    int rowLength = grid[0].length;
	    int columnLength = grid.length;
	    for (int i = 0; i < rowLength; i++) {
	        for (int j = 0; j < columnLength; j++) {
	            char c = grid[i][j];
	            if (c != '.') {
	                if (!set.contains(c))
	                    set.add(c);
	                else
	                    return false;
	            }
	        }
	        set.clear();
	    }
	    return true;    
	}
	
	// assuming this is a 9x9 grid
	private static boolean isSquare(char[][] grid) {
	    HashSet<Character> set = new HashSet<>();
	    int rowLength = grid[0].length;
	    int columnLength = grid.length;
	    for (int i = 0; i < rowLength; i += 3) {
	        for (int j = 0; j < columnLength; j += 3) {
	            
	            for (int k = i; k < i + 3; k++) {
	                for (int l = j; l < j + 3; l++) {
	                    char c = grid[k][l];
	                    
	                    if (c != '.') {
	                        if (!set.contains(c))
	                            set.add(c);
	                        else
	                            return false;
	                    }
	                }
	            }
	            set.clear();
	        }
	    }
	    return true;    
	}
}
