class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
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
}