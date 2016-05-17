class TrieNode {
	boolean is;
	TrieNode[] next;
    // Initialize your data structure here.
    public TrieNode() {
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        put(root, word, 0);
    }
    
    private TrieNode put(TrieNode x, String key, int d) {
		if (x == null)
			x = new TrieNode();
		if (d == key.length()) {
			x.is = true;
			return x;
		}
		int c = key.charAt(d) - 'a';
		x.next[c] = put(x.next[c], key, d + 1);
		return x;
	}

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode x = get(root, word, 0);
		if (x == null)
			return false;
		return x.is;
    }
    
    private TrieNode get(TrieNode x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		int c = key.charAt(d) - 'a';
		return get(x.next[c], key, d + 1);
	}

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode x = get(root, prefix, 0);
		return get(x);
    }
    
    private boolean get(TrieNode x) {
    	if (x == null)
    		return false;
    	if (x.is)
    		return true;
    	for (int i = 0; i < 26; i++)
    		if (get(x.next[i]))
    			return true;
    	return false;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
