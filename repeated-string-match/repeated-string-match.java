class Solution {
    // O(n*m) if StringBuilder
    public int repeatedStringMatch_v0(String a, String b) {
        int n = 0;
        for(String s = ""; n <= b.length()/a.length()+2; s += a, n++) 
            if(s.indexOf(b) != -1) return n;
        return -1;
    }
    
    // KMP O(n+m)
    public int repeatedStringMatch(String a, String b) {
        int n = 0;
        StringBuilder s = new StringBuilder();
        while(s.length() < b.length()) {s.append(a); n++;}
        
        if(match(s.toString().toCharArray(), b.toCharArray())) return n;
        if(match(s.append(a).toString().toCharArray(), b.toCharArray())) return n+1;
        return -1;
    }
    
    boolean match(char[] txt, char[] pat) {
        int[] p = kmp(pat);
        for(int i = 0, l = 0; i < txt.length && l < pat.length; i++) {
            while(l > 0 && txt[i] != pat[l]) l = p[l-1];
            l = l + (txt[i]==pat[l] ? 1 : 0);
            
            if(l == pat.length) return true;
        }
        return false;
    }
    
    // largest prefix suffix
    int[] kmp(char[] s) {
        int[] p = new int[s.length];
        
        p[0] = 0;
        for(int i = 1; i < s.length; i++) {
            int l = p[i-1];
            while(l > 0 && s[i] != s[l]) l = p[l-1];
            p[i] = l + (s[i]==s[l] ? 1 : 0);
        }
        
        return p;
    }
}
