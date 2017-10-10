package Recursion;
import java.util.*;

public class Subsets {
	
	private static LinkedList<LinkedList<Integer>> getSubsets(LinkedList<Integer> set,
			LinkedList<LinkedList<Integer>> allSubsetList) {
		
	    // when only one k element is left in the list, return the subset equal to {{},{k}}
		if (set.size() == 1) {
	        allSubsetList.add(new LinkedList<Integer>());
	        allSubsetList.add(new LinkedList<Integer>(set));
	        return allSubsetList;
	    }
	    else {
	    	
	    	// remove the last element from the set
	        Integer tmp = (Integer) set.removeLast();
	        
	        // a copy linkedlist for iterating over elemenets
	        LinkedList<LinkedList<Integer>> copyList = new LinkedList<LinkedList<Integer>>();
	        
	        // recursively call itself
	        copyList.addAll(getSubsets(set, allSubsetList));
	        
	        // after recursion reached its bottom, backtrack and add required subsets
	        for ( List<Integer> ls : copyList) {
	        	LinkedList<Integer> tmpList = new LinkedList<Integer>(ls);
	        	tmpList.add(tmp);
	            allSubsetList.add(new LinkedList<Integer>(tmpList));
	            
	        }
	        
	        return allSubsetList;
	    }
	}

	public static LinkedList<LinkedList<Integer>> getAllSubsets(LinkedList<Integer> list) {
		
		LinkedList<LinkedList<Integer>> allSubSets = new LinkedList<LinkedList<Integer>>();
		return getSubsets(list, allSubSets);
	}
	/*
	 * #7 Given a list of n distinct elements, write a function 
	 * that lists all subsets of those elements 
	 * (recursive and iterative solutions are possible)
	 * This is a recursive solution: running time: O(2^n)
	 * 
	 * Another solution (simpler) uses binary digits. Also solving with DFS is possible.
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		List<?> ls = getAllSubsets(list);
		System.out.println(ls.toString());
		System.out.println(ls.size());
	}
}
