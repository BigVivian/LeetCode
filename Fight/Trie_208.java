package Fight;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_208 实现前缀树
 * 
 * @author Vivian
 * 
 */
public class Trie_208 {
	private TrieNode root;

	public Trie_208() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode current = root;
		Map<Character, TrieNode> child = current.child;

		for (int i = 0; i <= word.length() - 1; i++) {
			char c = word.charAt(i);
			if (child.containsKey(c)) {
				current = child.get(c);
			} else {
				TrieNode newNode = new TrieNode(c);
				child.put(c, newNode);
				current = newNode;
			}

			child = current.child;

			if (i == word.length() - 1) {
				current.isLeaf = true;
			}
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {

		return containsPrefix(word) != null && containsPrefix(word).isLeaf;

	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {

		return containsPrefix(prefix) != null;
	}

	public TrieNode containsPrefix(String prefix) {

		TrieNode current = root;
		Map<Character, TrieNode> child = root.child;

		for (int i = 0; i <= prefix.length() - 1; i++) {
			char c = prefix.charAt(i);
			if (!child.containsKey(c)) {
				return null;
			}
			current = child.get(c);
			child = current.child;
		}

		return current;
	}

	static class TrieNode {
		// Initialize your data structure here.
		public char c;
		public boolean isLeaf;
		public Map<Character, TrieNode> child = new HashMap<Character, TrieNode>();

		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
			this.isLeaf = false;
		}
	}

	/**
	 * test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Trie_208 trie = new Trie_208();
		trie.insert("something");
		trie.insert("some");
		boolean res1 = trie.search("somet");
		boolean res2 = trie.startsWith("somet");

		System.out.println(res1 + " " + res2);
	}
}