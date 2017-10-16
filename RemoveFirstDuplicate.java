import java.util.*;

public class RemoveFirstDuplicate {
	// this solution will work with relaxed 
	// constraints: e.g. when -val<= a[i] <= +val
	private static int firstDuplicate(int[] a) {
	    int length = a.length;
	    HashSet<Integer> set = new HashSet<>();
	    for (int i = 0; i < length; i++) {
	        if (!set.contains(a[i]))
	            set.add(a[i]);
	        else
	            return a[i];
	    }
	    
	    return -1;
	}

	/*
	 * this solution is better then above because it doesn't need
	 * additional space. However, works only with the current constrains:
	 * e.g. 1 <= a[i] <= a.length;
	private static int firstDuplicate(int[] a) { 
	    System.out.println(Arrays.toString(a));
	    for (int i : a) {
	        
	        if (a[Math.abs(i)-1] < 0)
	            return Math.abs(i);
	        else
	            a[Math.abs(i)-1] = -a[Math.abs(i)-1];
	    }
	    return -1;
	}
	*/
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 0, 1, 5};
		System.out.println(firstDuplicate(arr));
	}
}

