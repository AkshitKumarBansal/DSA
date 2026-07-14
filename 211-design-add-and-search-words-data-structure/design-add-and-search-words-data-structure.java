class WordDictionary {
    
    // Define the TrieNode structure
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode() {
            children = new TrieNode[26]; // For 'a' through 'z'
            isEndOfWord = false;
        }
    }
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    // Helper method to handle the '.' wildcard using DFS
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        
        // If we have reached the end of the word, check if it's a valid word ending
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        
        char c = word.charAt(index);
        
        if (c == '.') {
            // If the character is a wildcard, check all possible paths (all non-null children)
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchHelper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false; // No valid path found
        } else {
            // If it's a standard character, proceed down the specific path
            int childIndex = c - 'a';
            return searchHelper(word, index + 1, node.children[childIndex]);
        }
    }
}