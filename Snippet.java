import java.util.*;

public class Snippet {
	static class Node {
		char c;
		int i,j;
		Node(char c, int i, int j) {
			this.c = c;
			this.i = i;
			this.j = j;
		}
	}
	
	public static boolean isWord(String s, char[][] arr) {
		if (s == null || arr == null) return false;
		
		int rowLength = arr[0].length;
	    int colLength = arr.length;

	    if (s.isEmpty() || s.length() > rowLength*colLength) return false;
	    
	    boolean[][] visited;
	    for (int i = 0; i < colLength; i++) {
	        for (int j = 0; j < rowLength; j++) {
	        	// important to clear the visited array after each iteration,
	        	// otherwise it will hold values from previous runs
	        	visited = new boolean[colLength][rowLength];
	            if (arr[i][j] == s.charAt(0)) {
	                if (checkWord(s, arr, i, j, visited)) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}
	
	// iterative DFS
	private static boolean checkWord(String s, char[][] arr, int i, int j, boolean[][] visited) {
	    
	    Stack<Node> tmpStack = new Stack<>();
	    Stack<Node> stack = new Stack<>();
	    
	    stack.push(new Node(arr[i][j], i, j));
	    visited[i][j] = true;
	    
	    while (!stack.isEmpty()) {
	        Node node = stack.pop();
	        
	        if (node.c == s.charAt(0)) {
	            s = s.substring(1);
	            tmpStack = getNextMoves(arr, node, visited);
	            stack.addAll(tmpStack);
	            //printStack(stack);
	            
	            // important to mark only one node as visited
	            // after it was popped.
	            visited[node.i][node.j] = true;
	        }
	        // also important to place this at the end
	        // and not at the beginning, otherwise becomes empty before 
	        // reaching this terminating if statement
	        if (s.length() == 0)
	        	return true;
	    }
	    return false;
	}
	
	// helper printStack method
	private static void printStack(Stack<Node> stack) {
		Stack<Node> s = new Stack<Node>();
        s.addAll(stack);
        if (!s.isEmpty()) {            
            while (!s.isEmpty()) {
                Node node = s.pop();
                System.out.print(node.c + " " + node.i + " " + node.j + ", ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty");
        }
		
	}

	private static Stack<Node> getNextMoves(char[][] arr, Node node, boolean[][] visited) {
	    Stack<Node> stack = new Stack<>();
	    int rowLength = arr[0].length;
	    int colLength = arr.length;
	
	    int i = node.i;
	    int j = node.j;
	    
	    // top
	    if (i > 0 && !visited[i-1][j]) {
	        stack.push(new Node(arr[i-1][j], i-1, j));
	    }
	
	    // bottom
	    if (i < colLength-1 && !visited[i+1][j]) {
	        stack.push(new Node(arr[i+1][j], i+1, j));
	    }
	
	    // left
	    if (j > 0 && !visited[i][j-1]){
	        stack.push(new Node(arr[i][j-1], i, j-1));
	    }
	
	    // right
	    if (j < rowLength - 1 && !visited[i][j+1]) {
	        stack.push(new Node(arr[i][j+1], i, j+1));
	    }
	    return stack;
	}
	public static void main(String[] args) {
		/**/char[][] arr = {{'A', 'B', 'C', 'E'},
						{'S', 'F', 'C', 'S'},
						{'A', 'D', 'E', 'E'}};
		
		//String s = "EEDASFCSECBA";
		//String s = "ABCESCFSADEE";
		//String s = "ASADFBCCEESE";
		String s = "ASFBCCE";
		//String s = null;
		System.out.println(isWord(s, arr));
	}
}