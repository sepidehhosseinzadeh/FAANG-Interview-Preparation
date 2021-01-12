class Solution {
    // there are cluster (cycle) of indice thet can freely swap
    // find those cycles by union-find
    // for each source value, find it's root index cycle, 
    // add it with its count.
    // we need to count the elems in each
    // and for each target match it with one of source cluster.
    public int minimumHammingDistance(int[] s, int[] t, int[][] e) {
        int n = s.length;
        int[] p = new int[n];
        for(int i = 0; i < n; i++) p[i]=i;
        
        for(int i = 0; i < e.length; i++) {
            int p1 = find(p,e[i][0]); 
            int p2 = find(p,e[i][1]);
            if(p1 != p2) p[p1] = p2;
        }
        
        // find count of each source and build a map of values of cluster
        HashMap<Integer, HashMap<Integer, Integer>> cluster = 
                new HashMap<>(); // cluster index -> count
        for(int i = 0; i < n; i++) {
            int p1 = find(p, i);
            //HashMap<Integer, Integer> valCnt = 
            //        cluster.getOrDefault(p1, new HashMap<>()); // this will NOT create a new map in cluster map!!!!!! (1) is necesary. Or first put cluster.putIfAbsent(p1, new HashMap<>()); then (1) is not needed!!!
            cluster.putIfAbsent(p1, new HashMap<>());
            HashMap<Integer, Integer> valCnt = cluster.get(p1); 
            valCnt.put(s[i], valCnt.getOrDefault(s[i], 0)+1);
            //cluster.put(p1, valCnt);
        }
        
        int diff = 0;
        for(int i = 0; i < n; i++) { 
            int p2 = find(p, i);
            HashMap<Integer, Integer> valCnt = cluster.get(p2);
            //if(!valCnt.containsKey(t[i])) diff++; // this will be covered in below line
            if(valCnt.getOrDefault(t[i], 0) == 0) diff++; // if count == 0 diff++!!!
            else valCnt.put(t[i], valCnt.get(t[i])-1);
        }
        
        return diff;
    }
    
    int find(int[] p, int i) {
        if(p[i] == i) return i;
        return p[i] = find(p, p[i]);
    }
}
