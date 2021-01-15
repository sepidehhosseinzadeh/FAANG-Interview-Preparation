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
        ArrayList<int[]> res = new ArrayList<>();
        
        for(String w : words) {
            int i = text.indexOf(w);
            while(i != -1) {
                res.add(new int[] {i, i+w.length()-1});
                i = text.indexOf(w, i+1);
            }
        }
        
        int[][] ret = new int[res.size()][2];
        int k = 0;
        for(int[] a : res) ret[k++] = a;
        Arrays.sort(ret, (i,j) -> i[0]!=j[0] ? i[0]-j[0] : i[1]-j[1]);
        return ret;
    }
    
}
