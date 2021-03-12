class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }

    public void insert(String w) {
        TrieNode at = this;
        for(int i = 0; i < w.length(); i++) {
            if(at.child[w.charAt(i)-'a'] == null) 
                at.child[w.charAt(i)-'a'] = new TrieNode();
            at = at.child[w.charAt(i)-'a'];
        }
        at.isEnd = true;
    }

    public boolean search(String w) {
        TrieNode at = this;
        for(int i = 0; i < w.length(); i++) {
            if(at.child[w.charAt(i)-'a'] == null) return false;
            at = at.child[w.charAt(i)-'a'];
        }
        return at.isEnd;
    }
}

class Solution {
    // trie o(n^2)
    public int[][] indexPairs_v0(String text, String[] words) {
        char[] ch = text.toCharArray();
        ArrayList<int[]> res = new ArrayList<>();
        
        TrieNode trie = new TrieNode();
        for(String w : words) trie.insert(w);
        
        for(int i = 0; i < ch.length; i++)
            if(trie.child[ch[i]-'a'] != null) { // all potential starts
                TrieNode t = trie;
                int j = i;
                while(j < ch.length && t.child[ch[j]-'a'] != null) {
                    t = t.child[ch[j]-'a'];
                    if(t.isEnd) res.add(new int[] {i,j});
                    j++;
                }
            }
        
        int[][] ret = new int[res.size()][2];
        int k = 0;
        for(int[] a : res) ret[k++] = a;
        
        return ret;
    }
    
    public int[][] indexPairs(String text, String[] words) {
        char[] ch = text.toCharArray();
        ArrayList<int[]> list = new ArrayList<>();
        
        for(String w : words) {
            int i = text.indexOf(w);
            while(i != -1) {
                list.add(new int[] {i, i+w.length()-1});
                i = text.indexOf(w, i+1);
            }
        }
        
        list.sort((i,j) -> i[0]!=j[0] ? i[0]-j[0] : i[1]-j[1]);
        return list.toArray(new int[0][0]);
    }
}
