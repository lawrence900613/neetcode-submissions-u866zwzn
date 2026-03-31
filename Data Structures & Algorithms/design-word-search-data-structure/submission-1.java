class TrieNode {
    TrieNode[] characters;
    boolean isEndOfWord;
    public TrieNode() {
        this.characters = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char s : word.toCharArray()) {
            if (curr.characters[s - 'a'] == null) {
                TrieNode node = new TrieNode();
                curr.characters[s - 'a'] = node;
            } 
            curr = curr.characters[s - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return explore(root, word);
    }

    public boolean explore(TrieNode curr, String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.characters[j] != null) {
                        if (explore(curr.characters[j], word.substring(i + 1, length))) {
                            return true;
                        }
                    }
                }
                return false;
            } else if (curr.characters[word.charAt(i) - 'a'] == null) {
                return false;
            } else {
                curr = curr.characters[word.charAt(i) - 'a'];
            }
        }
        return curr.isEndOfWord;
    }
  }
