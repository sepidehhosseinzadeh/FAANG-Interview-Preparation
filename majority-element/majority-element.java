class Solution {
    public int majorityElement_v0(int[] nums) {
        var cnt = new HashMap<Integer, Integer> ();
        
        for(int i : nums) {
            cnt.put(i, cnt.getOrDefault(i,0)+1);
            if(cnt.get(i) > nums.length/2) return i;
        }
        
        return -1;
    }
    
    // Boyer-Moore Voting - o(n)
    // counter++ when we see the potential candidate, o.w. counter--.
    // when counter is 0, then change the potential candidate to current one. 
    // coz the majority element will apear more than n/2, 
    // then whenever we encounter a new elemnt and counter--, 
    // at the end the majority elemnt will remain
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return -1;
        int cnt = 0;
        int cand = nums[0];
        for(int i : nums) {
            if(cnt == 0) cand = i;
            cnt += i == cand ? 1 : -1;
        }
        return cand;
        
    }
}
