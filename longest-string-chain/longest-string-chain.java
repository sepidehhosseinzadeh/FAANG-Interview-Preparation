class Solution {
    // memo is better time
    int maxLen;
    public int longestStrChain_v0(String[] words) {
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
    
    // DP 
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (i,j) -> i.length()-j.length()); // go in order
        Map<String, Integer> dp = new HashMap<>();
        int max = 0;
        for(String w : words) { // for each w to be added, find neighbors with missing 1 char in dp, and update +1
            int best = 1;
            for(int i = 0; i < w.length(); i++) {
                String prev = w.substring(0,i)+w.substring(i+1);
                best = Math.max(best, dp.getOrDefault(prev,0)+1);
            }
            dp.put(w, best);
            max = Math.max(best, max);
        }
        return max;
    }
}
