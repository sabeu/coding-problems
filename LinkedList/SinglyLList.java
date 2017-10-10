package LinkedList;
import java.util.*;


public class SinglyLList {
	private class LLNode {
		private Object data;
		private LLNode nextLLNode;
		
		LLNode (Object key) {
			this.data = key;
			nextLLNode = null;
		}
		public Object getData() {
			return data;
		}
		
		public LLNode getNextLLNode() {
			return nextLLNode;
		}
		
		@SuppressWarnings("unused")
		public void setData(Object data) {
			this.data = data;
		}
		
		public void setNextLLNode(LLNode node) {
			this.nextLLNode = node;
		}
	}
	
	private LLNode head;
	private static int size;
	
	public SinglyLList() {
		head = null;
		size = 0;
	}
	
	public void incrementSize() {
		size++;
	}
	
	public void decrementSize() {
		size--;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertLast(Object data) {
		if (head == null) {
			head = new LLNode(data);
			return;
		}
		
		LLNode tmpNode = head;
		
		while (tmpNode.getNextLLNode() != null) {
			tmpNode = tmpNode.getNextLLNode();
		}
		tmpNode.setNextLLNode(new LLNode(data));
		incrementSize();
	}
	
	// Method 1: reverse LList with a stack
	// given that we can use only setNext method
	// time: O(n)
	// space: O(n)
	public boolean reverseLList1() {
		if (head == null || head.getNextLLNode() == null)
			return false;
		
		LLNode tmpNode = head;
		
		Stack<Object> st = new Stack<Object>();
		
		while (tmpNode != null) {
			st.push(tmpNode.getData());
			tmpNode = tmpNode.getNextLLNode();
		}
		
		LLNode newNode = new LLNode(st.pop());
		head = newNode;
		
		while (!st.isEmpty()) {
			newNode.setNextLLNode(new LLNode(st.pop()));
			newNode = newNode.getNextLLNode();
		}
		
		return true;
	}
	
	// Method 2: Iteratively change pointers while
	// traversing the list
	// time O(n)
	// space O(1)
	public boolean reverseLList2() {
		if (head == null || head.getNextLLNode() == null)
			return false;
		
		LLNode prev = null, next = null;
		LLNode curr = head;
		
		while(curr != null) {
			next = curr.getNextLLNode();
			curr.setNextLLNode(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
		
		return true;
	}
	
	// Method 3: Recursively visit every node until the last node, then
	// point head to the last element, and on the return path point each node (predecessor)
	// as the successor to each visited node.
	// time O(n), space O(n)
	// recursive approaches use stack (in memory - method call stack).
	// therefore, the more elements a linked list holds, the more method calls in memory stack will be created!
	public boolean reverseList3() {
		if (head == null || head.getNextLLNode() == null)
			return false;

		head = reverseList3Rec(head);
		return true;
	}
	
	// utility method for recursive reversal
	private LLNode reverseList3Rec(LLNode head) {
		if (head == null || head.getNextLLNode() == null) {
			return head;
		}
		LLNode newHead = reverseList3Rec(head.getNextLLNode());
		head.getNextLLNode().setNextLLNode(head);
		head.setNextLLNode(null);
		
		return newHead;
	}
	
	// Method 4: using insertFirst() method while traversing the list
	// add each visited node to the head of the new list (new list is
	// created by setting the head's next node to null and using head to
	// iteratively attach new nodes to the head).
	// time O(n)
	// space O(1)
	// Alternative method would be to create a new LList and add the nodes
	// to that list instead of doing it in-place. Note, that the return type
	// for this method then should be LList instead of boolean because the method
	// will need to return newly created list.
	public boolean reverseList4() {
		if (head == null || head.getNextLLNode() == null) {
			return false;
		}
		
		LLNode tmpNode = head.getNextLLNode();
		head.setNextLLNode(null);
		
		while(tmpNode != null) {
			insertFirst(tmpNode.getData());
			tmpNode = tmpNode.getNextLLNode();
		}
		
		return true;
	}
	
	// Method 5: Recursively traverses to the end of the list,
	// but before each recursive call, the pointers are reassigned in
	// opposite direction. This method is called tail recursion.
	// time O(n)
	// space O(n) - because of recursion (method call stack)
	public LLNode reverseList5() {		
		return reverseList5Rec(null, head);
	}
	
	// utility recursion method for reverseList5 method
	private LLNode reverseList5Rec(LLNode prev, LLNode cur) {
		if (cur.getNextLLNode() == null) {
			head = cur;
			cur.setNextLLNode(prev);
			return null;
		}
		LLNode next = cur.getNextLLNode();
		cur.setNextLLNode(prev);
		reverseList5Rec(cur, next);
		
		return head;
	}
	
	public void insertFirst(Object data) {
		LLNode newNode = new LLNode(data);
		newNode.setNextLLNode(head);
		head = newNode;
		return;
	}
	
	public void printLList() {
		LLNode tmpNode = head;
		while (tmpNode.getNextLLNode() != null) {
			System.out.print(tmpNode.getData().toString() + " -> ");
			tmpNode = tmpNode.getNextLLNode();
		}
		System.out.println(tmpNode.getData());
	}

    // removes first occurrence of the specified element from the LL
    public boolean removeFirst(Object data) {

        // check if the list is empty
        if (head == null) {
            // either throw an exception or return
            //throw new RunTimeException(“The list is empty, can not delete!”);
            return false;
        }

        // check if the first element is equal to the element and if so, delete it
        if (head.getData().equals(data)) {
            head = head.getNextLLNode();
            return true;
        }

        // create temporary nodes for storing the pointers
        LLNode currNode = head;

        // traverse the LL until the element is found or end of list
        // and update temporary pointers of the previous and current nodes
        while (currNode != null && !currNode.getData().equals(data)) {
            currNode = currNode.getNextLLNode();
        }

        // check if LL doesn’t contain the element (i.e. reached end of list)
        if (currNode == null) {
            // either throw an exception or return
            //throw new RunTimeException(“No element found, can not delete!”);
            return false;
        }

        // delete the matching node by updating pointers
        currNode.setNextLLNode(currNode.getNextLLNode().getNextLLNode());

        // decrement size of the LL
        decrementSize();

        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLList list = new SinglyLList();
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.printLList();
		list.removeFirst(1);
		list.printLList();
		list.removeFirst(2);
		list.printLList();
		//list.reverseLList1();
		//list.printLList();
		list.reverseLList2();
		list.printLList();
		list.reverseList3();
		list.printLList();
		list.insertFirst(5);
		list.printLList();
		list.reverseList4();
		list.printLList();
		list.insertFirst(7);
		list.printLList();
		list.reverseList5();
		list.printLList();
	}

}
