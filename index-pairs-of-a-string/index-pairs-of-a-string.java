        for(int i = 0; i < w.length(); i++) {
            if(at.child[w.charAt(i)-'a'] == null) return false;
            at = at.child[w.charAt(i)-'a'];
        }
        return at.isEnd;
    }
}
​
class Solution {
    public int[][] indexPairs(String text, String[] words) {
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
    
}
