package Tree;
import java.util.*;

/*
 * This implementation uses associative arrays as DS.
 * Binary tries could be used to represent bits (words as bits, etc). This is more space-efficient.
 * Another option is to use a LinkedList with 2 pointers: forward movement and same-level movement.
 * This is also better than using arrays space-wise. Another, alternative is Ternary Search Tries.  
 */
public class Trie {
	static final int ALPHABET_SIZE = 26;
	
	class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isLeaf;
		
		TrieNode() {
			isLeaf = false;
			for (int i = 0; i < ALPHABET_SIZE; i++ ) {
				children[i] = null;
			}
		}
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	void insert(String key) {
		int level;
        int length = key.length();
        int index;
      
        TrieNode pCrawl = getRoot();
      
        for (level = 0; level < length; level++) {
            index = Character.toLowerCase(key.charAt(level)) - 'a';
            //System.out.println(index+ " " + key.charAt(level));
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isLeaf = true;
	}
	
	boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode node = getRoot();

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
      
            if (node.children[index] == null)
                return false;
      
            node = node.children[index];
        }

        return (node != null && node.isLeaf);
    }
	

	/*
	 * #33 Write a function that, given a pointer to the root of a trie,
	 * prints out all words in that trie.
	 * Data structure implementation is taken from geeksforgeeks.com, 
	 * solution for printing a trie is mine.
	 */
	public ArrayList<String> getKeys() {
		TrieNode node = getRoot();
		if (isNull(node)) return null;
		
		ArrayList<String> keys = new ArrayList<String>();
		printTrieRec(node, "", keys);
		return keys;
	}
	
	public void printTrie() {
		TrieNode node = getRoot();
		if (isNull(node)) {
			System.out.println("Trie is empty!");
			return;
		}
		
		ArrayList<String> keys = new ArrayList<String>();
		printTrieRec(node, "", keys);
		System.out.println(keys.toString());
		System.out.println("");		
	}
	
	private boolean isNull(TrieNode node) {
		if (node != null) {
			boolean anyChildren = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				if (node.children[i] != null) {
					anyChildren = true;
					break;
				}
			}
			if (!anyChildren) {
				return true;
			}
		}
		return false;
	}
	
	
	private void printTrieRec(TrieNode root, String str, ArrayList<String> keys) {
		TrieNode node = root;
		if (isNull(node)){
			keys.add(str);
			return;
		}
			
		if (node.isLeaf) {
			//System.out.println(str);
			keys.add(str);
		}
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (node.children[i] != null) {
				printTrieRec(node.children[i], (str + (char) (i + 'a')), keys);
			}
		}
	}
	
	/*
	 * Merges a trie with the current one.
	 * Returns updated trie.
	 */
	public Trie combineWith(Trie trie) {
		ArrayList<String> keys = trie.getKeys();
		for (String s : keys) {
			this.insert(s);
		}
		return this;
	}
	
	/*
	 * Auto-complete feature 
	 */
	public ArrayList<String> getWords(String key) {
		TrieNode node = getRoot();
		ArrayList<String> words = new ArrayList<String>();
		for (int i = 0; i < key.length(); i++) {
			int j = key.charAt(i) - 'a';
			if (node.children[j] == null) return words;
			node = node.children[j];
		}
		getAllWordsRec(node, key, words);
		return words;
	}
	
	private void getAllWordsRec(TrieNode root, String s, ArrayList<String> words) {
		TrieNode node = root;
		ArrayList<String> word = words;
		if (isNull(node) && node.isLeaf) {
			words.add(s);
			word.add("hello there");
			return;
		}
		
		if (node.isLeaf) {
			//System.out.println(words);
			//System.out.println(word);
			words.add(s);
		}
		
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (node.children[i] != null) {
				getAllWordsRec(node.children[i], (s + (char) (i + 'a')), words);
			}
		}
	}

	
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("helping");
		trie.insert("Morning");
		trie.insert("helicopter");
		trie.insert("Helsinki");
		trie.insert("hilarious");
		trie.insert("hi");
		trie.printTrie();
		
		Trie secondTrie = new Trie();
		//secondTrie.insert("go"); ???
		secondTrie.insert("good");
		secondTrie.insert("google");
		secondTrie.insert("golang");
		secondTrie.insert("go");
		secondTrie.insert("goggle");
		secondTrie.insert("greatness");
		secondTrie.printTrie();
		
		trie.combineWith(secondTrie);
		trie.printTrie();
		System.out.println(trie.getWords("g").toString());
		
	}

}
