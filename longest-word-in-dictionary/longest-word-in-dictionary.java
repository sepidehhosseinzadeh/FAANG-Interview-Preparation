class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> canBuild = new HashSet<>();
        
        for(String w : words) {
            if(w.length()==1 || canBuild.contains(w.substring(0,w.length()-1))) {
                res = w.length() > res.length() ? w : res;
                canBuild.add(w);
            }  
        }
        
        return res;
    }
}
