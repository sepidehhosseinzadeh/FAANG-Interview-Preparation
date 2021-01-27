class Solution {
    public boolean isNStraightHand_v0(int[] hand, int w) {
        if(hand.length%w != 0) return false;
        
		TreeMap<Integer, Integer> cnt = new TreeMap<>();
		for (int i : hand) cnt.put(i, cnt.getOrDefault(i, 0) + 1);

		while(!cnt.isEmpty()) {
			int at = cnt.firstKey();
            for(int i = 0; i < w; i++) {
                if(!cnt.containsKey(at+i)) return false;
                cnt.put(at+i, cnt.get(at+i)-1);
                cnt.remove(at+i, 0);
			}
		}
		return true;
    }
    
    public boolean isNStraightHand_v1(int[] hand, int w) {
        if(hand.length%w != 0) return false;
        
		TreeMap<Integer, Integer> cnt = new TreeMap<>();
		for (int i : hand) cnt.put(i, cnt.getOrDefault(i, 0) + 1);

		for(int at : cnt.keySet())
            if(cnt.get(at) > 0)
                for(int i = w-1; i >= 0; i--) { // update last cnt.get(at) needed
                    if(cnt.getOrDefault(at+i,0) < cnt.get(at)) return false;
                    cnt.put(at+i, cnt.get(at+i)-cnt.get(at));
                    //cnt.remove(at+i, 0);
                }
		
		return true;
    }
    
    public boolean isNStraightHand(int[] hand, int w) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : hand) q.add(i);
        
        while(!q.isEmpty()) {
            int at = q.poll();
            for(int i = 1; i < w; i++) 
                if(!q.remove(at+i)) return false;
        }
        return true;
    }
}
