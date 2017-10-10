package Tree;

public class BST {

	class Node {
		int key;
		Node left, right;
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	
	Node root;
	
	public BST() {
		root = null;
	}
	
	boolean checkBST() {
        return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBSTUtil(Node root, int min, int max) {
        if (root == null) return true;
        if (root.key < min || root.key > max) return false;
        return (checkBSTUtil(root.left, min, root.key-1) && checkBSTUtil(root.right, root.key+1, max));
    }
    
	void insert(int key) {
		root = insertBST(root, key);
	}
	
	Node insertBST(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		else {
			if (root.key > key) {
				root.left = insertBST(root.left, key);
			}
			if (root.key < key) {
				root.right = insertBST(root.right, key);
			}
		}
		return root;
	}
	
	void deleteKey(int key) {
		root = deleteRec(root, key);
	}
	
	Node deleteRec(Node root, int key) {
		if(root == null) {
			return root;
		}
		if (root.key > key) {
			root.left = deleteRec(root.left, key);
		} else if (root.key < key) {
			root.right = deleteRec(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.key = nextSuccessor(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}
	
	int nextSuccessor(Node root) {
		int successor = root.key;
		while(root.left != null) {
			successor = root.left.key;
			root = root.left;
		}
		return successor;
	}
	
	Node search(Node root, int key) {
		if (root == null || root.key == key) {
			return root;
		}
		if (root.key > key) {
			return search(root.left, key);
		}
		return search(root.right, key);
	}
	
	void printInOrderBST() {
		printInOrder(root);
	}
	
	void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.key + " ");
			printInOrder(root.right);			
		}
	}
	
	void printBST() {
		printTree(root);
	}
	
	void printTree(Node root) {
		int h = getHeight(root);
		printTreeRec(root, h);
		
		//System.out.println(h);
	}
	
	void printTreeRec(Node root, int h) {
		double width = Math.pow(2, h+1) - 1;
		int level = 0;
		while (level <= h) {
			double n = Math.pow(2, level); 
			
			for (int i = 1; i < width; i++) {
				
				if (i == (int) Math.pow(2, h)) {
					System.out.println("x");
				} else {
					System.out.println("-");
				}
			}
			level++;
		}
			
		System.out.println();
		System.out.println(root.key);
		System.out.println();
	}
	
	int getHeight(Node root) {
		if (root == null) {
			return -1;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(6);
		bst.insert(3);
		bst.insert(9);
		bst.insert(4);
		bst.insert(8);
		bst.insert(10);
		bst.insert(11);
		bst.insert(12);
		//bst.printTree(bst.root);
		bst.printInOrderBST();
		System.out.println("");
		System.out.println(bst.checkBST());
//		System.out.println(bst.search(bst.root, 7));
//		System.out.println(bst.search(bst.root, 4).key);
		bst.deleteKey(6);
		bst.deleteKey(4);
		bst.printInOrder(bst.root);
	}

}
