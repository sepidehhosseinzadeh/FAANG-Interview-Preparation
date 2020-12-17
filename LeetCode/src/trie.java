class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}
class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String w) {
        TrieNode at = root;
        for(int i = 0; i < w.length(); i++) {
            if(at.child[w.charAt(i)-'a'] == null) // this if is IMPORTANT!!!!! o.w. the info inside node will be gone!!!!
                at.child[w.charAt(i)-'a'] = new TrieNode();
            at = at.child[w.charAt(i)-'a'];
        }
        at.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String w) {
        TrieNode at = root;
        for(int i = 0; i < w.length(); i++) {
            if(at.child[w.charAt(i)-'a'] == null) return false;
            at = at.child[w.charAt(i)-'a'];
        }
        return at.isEnd;
    }
    // word may contain dots '.' where dots can be matched with any letter.
    public boolean searchWithDot(String w) {
        return search(w, 0, root);
    }
    public boolean search(String w, int idx, TrieNode at) {
        if(idx == w.length()) return at!= null && at.isEnd;
        if(at == null) return false;

        if(w.charAt(idx) != '.') {
            return search(w,idx+1,at.child[w.charAt(idx)-'a']);
        } else {
            for(int j = 0; j < 26; j++)
                if(at.child[j] != null)
                    if(search(w,idx+1,at.child[j]))
                        return true;
            return false;
        }

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String w) {
        TrieNode at = root;
        for(int i = 0; i < w.length(); i++) {
            if(at.child[w.charAt(i)-'a'] == null) return false;
            at = at.child[w.charAt(i)-'a'];
        }
        return true;
    }
}