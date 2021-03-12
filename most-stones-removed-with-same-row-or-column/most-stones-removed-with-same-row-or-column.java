class Solution {
    // o(n^2)
    public int removeStones_v0(int[][] s) {
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
    
    
    // o(n) : stone's cordinates can be union, 
    // coz if they have a same x or y they are in 
    // the same component (tree)
    // we can distinguish x and y by using ~y or y+MAX
    int cc = 0;
    public int removeStones(int[][] s) {
        int n = s.length;
        var p = new HashMap<Integer, Integer>();
        
        for(int[] stone: s) {
            int p1 = unionFind(p,stone[0]);
            int p2 = unionFind(p,~stone[1]);
            if(p1 != p2) {
                cc--;
                p.put(p1,p2);
            }
        }
        return n - cc;
    }
    private int unionFind(HashMap<Integer, Integer> p, int i) {
        if(!p.containsKey(i)) {p.put(i,i); cc++;}
        if(i == p.get(i)) return i;
        p.put(i, unionFind(p, p.get(i)));    
        return p.get(i);
    }
}
