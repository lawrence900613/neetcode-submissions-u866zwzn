class TrieNode {
    char alphabet;
    TrieNode[] characters;
    boolean isEndOfWord;
    public TrieNode(char alphabet) {
        this.alphabet = alphabet;
        this.characters = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode('.');
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char s : word.toCharArray()) {
            if (curr.characters[s - 'a'] == null) {
                TrieNode node = new TrieNode(s);
                curr.characters[s - 'a'] = node;
            } 
            curr = curr.characters[s - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char s : word.toCharArray()) {
            if (curr.characters[s - 'a'] == null) {
                return false;
            } else {
                curr = curr.characters[s - 'a'];
            }
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char s : prefix.toCharArray()) {
            if (curr.characters[s - 'a'] == null) {
                return false;
            } else {
                curr = curr.characters[s - 'a'];
            }
        }
        return true;
    }
}
