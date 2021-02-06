class Solution {
    public int minimumLength(String ss) {
        int n = ss.length();
        if(n==1) return 1;
        char[] s = ss.toCharArray();
        int i = 0, j = n-1;
        while(i < j) {
            char c = s[i];
            if(s[i] != s[j]) break;
            while(i <= j && s[i]==c) s[i++] = '-';
            while(j > i && s[j]==c) s[j--] = '-';
        }
        int res = 0;
        for(char c : s) if(c != '-') res++;
        return res;
    }
}