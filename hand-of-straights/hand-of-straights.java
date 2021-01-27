class Solution {
    public boolean isNStraightHand(int[] hand, int w) {
        if(hand.length%w != 0) return false;
        
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int i : hand) cnt.put(i, cnt.getOrDefault(i, 0) + 1);
​
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
}
