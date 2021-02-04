class Solution {
    public int removeStones(int[][] s) {
        int n = s.length;
        int[] p = new int[n];
        for(int i = 0; i < n; p[i]=i++);
        
        int cc = n;
        for(int i = 0; i < n; i++) 
            for(int j = i+1; j < n; j++) {
                if(!isNeigh(s[i], s[j])) continue;
                int p1 = unionFind(p,i);
                int p2 = unionFind(p,j);
                if(p1 != p2) {
                   cc--;
                    p[p1] = p2;
                }
            }
        return n - cc;
    }
    private int unionFind(int[] p, int i) {
        if(p[i] != i) return p[i] = unionFind(p,p[i]);
        return i;
    }
    private boolean isNeigh(int[] a, int[] b) {
        return a[0]==b[0] || a[1] == b[1];
    }
}