import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestSequence {

	public static void main(String[] args) {
		//int[] a = {3,2,1,4,5,6,4,5};
		int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println(Arrays.toString(longestSubsequentSequence(a)));
		System.out.println(Arrays.toString(longestSubsequence(a)));
		System.out.println(longestSubsequentSequence2(a));
	}

	// returns a longest sequence (not subsequent) in O(n^2) time
	// this approach finds the longest subsequence but not not all the longest subsequences
	// (there could be more than one subsequence of the same length)
	private static int[] longestSubsequence(int[] a) {
		if (a == null) return new int[]{};
		int length = a.length;
		if (length == 1) return a;
		// array storing the lengths of the longest subsequences for each 'i'
		int[] countArr = new int[length];
		
		// list storing the subsequences (the elements) for each 'i' 
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		// initialize the array and list
		for (int k = 0; k < length; k++) {
			countArr[k] = 1;
			list.add(new ArrayList<Integer>());
		}

		list.get(0).add(a[0]);
		
		// following two variables are needed for 
		// the pointer pointing to to longest subsequence 
		int longestLength = 0;
		ArrayList<Integer> lst = new ArrayList<>();
		
		// count the number of subsequences for each 'i' in countArr
		// store the subsequences for each 'i' in list
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					if (countArr[j] + 1 > countArr[i]) {
						if (list.get(i).size() < list.get(j).size() + 1) {
							list.get(i).clear();
							list.get(i).addAll(list.get(j));
						}
						countArr[i] = countArr[j] + 1;
					}
				}
			}
			list.get(i).add(a[i]);
			
			// update pointers to the longest subsequence
			if (list.get(i).size() > longestLength) {
				longestLength = list.get(i).size();
				lst = list.get(i);
			}
		}
		
		// convert from ArrayList to int[]
		int[] longestSeq = new int[longestLength];
		for (int s = 0; s < longestLength; s++) {
			longestSeq[s] = lst.get(s);
		}
		
		
		return longestSeq;
	}

	// returns a longest subsequent sequence, time O(n), space O(n)
	private static int[] longestSubsequentSequence(int[] a) {
		if (a == null) return new int[0];
		if (a.length == 1) return a;
		ArrayList<ArrayList<Integer>> D = new ArrayList<>();
		D.add(new ArrayList<Integer>());
		int length = a.length;
		for (int i = 0; i < length - 1; i++) {
			if (a[i] < a[i+1]) {
				D.get(D.size()-1).add(a[i]);
			}
			else {
				if (i > 0) {
					if (a[i-1] < a[i]) {
						D.get(D.size()-1).add(a[i]);
						D.add(new ArrayList<Integer>());
					}
				}
			}
		}
		
		// add the last element if condition is met
		// since the for loop above iterates only until 'length-1'th element
		if (a[length-2] < a[length-1])
			D.get(D.size()-1).add(a[length-1]);
		
		int size = D.get(0).size();
		ArrayList<Integer> longestList = new ArrayList<>();
		longestList = D.get(0);
		
		// get the longest list
		for (ArrayList<Integer> list : D) {
			if (list.size() > size) {
				size = list.size();
				longestList = list;
			}
		}
		
		// convert from ArrayList to int[]
		int[] longestSeq = new int[size];
		for (int j = 0; j < size; j++) {
			longestSeq[j] = longestList.get(j);
		}
		
		return longestSeq;
	}
	
	// returns the size of the longest subarray
	// this approach could be extended to return subarray instead of the length (number)
	private static int longestSubsequentSequence2(int[] a) {
		int start = 0, end = 1, max_len = 1;
		
		while (end < a.length) {
			if (a[end] > a[end - 1]) {
				if (end - start + 1 > max_len) {
					max_len = end - start + 1;
				}
			}
			else
				start = end;
			end++;
		}
		
		return max_len;
	}

}
