package Recursion;
import java.util.*;

/**
 * Problem title:
 * Can you reach zero in the array game?
 *
 * Definition:
 * You're given an array of integers, such as arr = [3, 4, 2, 3, 0, 3, 1, 2, 1], 
 * and a startIndex. When you're at an index i, you can move left or right by arr[i]. 
 * Your task is to figure out if you can reach 0.
 */

public class ReachZero {

	public static boolean solve(int[] A, int startIndex) {
		
		Set<Integer> set = new HashSet<Integer>();
	    
	    return isZeroReachableRec(A, startIndex, set);
	}
	
	public static boolean isZeroReachableRec(int[] A, int startIndex, Set<Integer> set) {
		//System.out.println(startIndex + " new iteration");
		if (startIndex < 0 || startIndex > (A.length - 1)) 
			return false;
		else {
			int val = A[startIndex];
			if (val == 0) return true;
			else {
				if (set.contains(startIndex)) return false;
				else {
					set.add(startIndex);
					return (isZeroReachableRec(A, startIndex - val, set) ||
							isZeroReachableRec(A, startIndex + val, set));
				}
			}
		}
	}
	
	// time O(n)
	// space O(n) - using set for storing visited indices
	// In order to not cycle infinitely, we need to track of visited indices,
	// this technique is called memoization: we use a HashSet for that.
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 0, 4, 2, 1};
		int startIndex = 4;
		System.out.println(solve(A, startIndex));
	}

}
