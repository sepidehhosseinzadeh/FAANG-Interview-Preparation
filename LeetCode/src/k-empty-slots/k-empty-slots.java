class Solution {
    // O(nlogn)
    public int kEmptySlots_v0(int[] bulbs, int k) {
        var s = new TreeSet<Integer>(); 
        
        for(int i = 0; i < bulbs.length; i++) {
            Integer lo = s.lower(bulbs[i]);
            Integer hi = s.higher(bulbs[i]);
            if(lo != null && bulbs[i]-lo-1==k) return i+1;
            if(hi != null && hi-bulbs[i]-1==k) return i+1;
            s.add(bulbs[i]);
        }
        
        return -1;
    }
    
    // o(n)
    // find a window [lb ub] with length k+1 that
    // all the days inside it are greater than [lb ub]
    public int kEmptySlots(int[] bulbs, int k) {
        int nday = bulbs.length;
        int[] day = new int[nday];
        for(int i = 0; i < nday; i++) day[bulbs[i]-1] = i+1;
        
        int lb = 0, ub = k+1, minDay = Integer.MAX_VALUE;
        for(int i = 0; ub < nday; i++) {
            if(day[i] > day[lb] && day[i] > day[ub]) continue; // out of current range
            if(i == ub) minDay = Math.min(minDay, Math.max(day[lb], day[ub]));
            lb = i;
            ub = i+k+1;
        }
        return minDay == Integer.MAX_VALUE ? -1 : minDay;
    }
}
