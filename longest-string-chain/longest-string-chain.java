class Solution {
    int maxLen;
    
    public int longestStrChain(String[] words) {
        var dic = new HashSet<String>();
        for(String w : words) dic.add(w);
        maxLen = 0;
        
        for(String w : words) {
            Set<String> res = new HashSet<>();
            res.add(w);
            dfs(new StringBuilder(w), dic, res); 
        }
        
        return maxLen;
    }
    void dfs(StringBuilder at, HashSet<String> dic, Set<String> res) {
        maxLen = Math.max(maxLen, res.size());
        
        for(int i = 0; i <= at.length(); i++)
            for(char c='a'; c <= 'z'; c++) {
                StringBuilder to = new StringBuilder(at);
                to.insert(i, c);
                if(dic.contains(to.toString()) && !res.contains(to.toString())) { 
                    res.add(to.toString());
                    dfs(to, dic, res);
                    res.remove(to.toString());
                }
            }
    }
}
