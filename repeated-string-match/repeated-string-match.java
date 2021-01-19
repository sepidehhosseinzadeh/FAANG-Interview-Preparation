class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = 0;
        for(String s = ""; n <= b.length()/a.length()+2; s += a, n++) 
            if(s.indexOf(b) != -1) return n;
        return -1;
    }
}
