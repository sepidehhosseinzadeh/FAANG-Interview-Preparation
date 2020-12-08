import java.util.*;

class TrieNode {
    char val;
    TrieNode[] child;
    boolean isWord;
    TrieNode(char v)
    {
        val = v;
        child = new TrieNode[26];
        isWord = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        char[] ch = word.toCharArray();
        TrieNode t = root;
        for(char c : ch)
        {
            if(t.child[c-'a'] == null)
                t.child[c-'a'] = new TrieNode(c);
            t = t.child[c-'a'];
        }
        t.isWord = true;
    }

    public boolean search(String word) {
        char[] ch = word.toCharArray();
        TrieNode t = root;
        for(char c : ch)
        {
            if(t.child[c-'a'] == null) return false;
            t = t.child[c-'a'];
        }
        return t.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] ch = prefix.toCharArray();
        TrieNode t = root;
        for(char c : ch)
        {
            if(t.child[c-'a'] == null) return false;
            t = t.child[c-'a'];
        }
        return true;
    }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/