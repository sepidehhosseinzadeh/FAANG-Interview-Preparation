class Solution {
    public String longestCommonPrefix(String[] strs) {
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
}
