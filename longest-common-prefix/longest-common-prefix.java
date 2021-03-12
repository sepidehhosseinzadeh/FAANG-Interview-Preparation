class Solution {
    public String longestCommonPrefix_v0(String[] strs) {
        if(strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++) {
            if(!same(i, strs)) return strs[0].substring(0,i);
        }
        return strs[0];
    }
    boolean same(int idx, String[] s) {
        char c = s[0].charAt(idx);
        for(int i = 0; i < s.length; i++)
            if(idx >= s[i].length() || s[i].charAt(idx) != c) return false;
        return true;
    }
    
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String pre = strs[0];   
        for(int i = 1; i < strs.length; i++)
            while(!strs[i].startsWith(pre)) // indexOf(pre) != 0
                pre = pre.substring(0, pre.length()-1);
        return pre;
    }
}
