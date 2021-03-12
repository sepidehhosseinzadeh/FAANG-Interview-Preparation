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
    public int majorityElement_v1(int[] nums) {
        if(nums.length == 0) return -1;
        int cnt = 0;
        int cand = nums[0];
        for(int i : nums) {
            if(cnt == 0) cand = i;
            cnt += i == cand ? 1 : -1;
        }
        return cand;
        
    }
    
    // bit manipulation
    // the bits of majority elemnt are repeated more than other elemnts.
    public int majorityElement(int[] nums) {
        int candid = 0;
        for(int i = 0; i < 32; i++) {
            int cnt = 0;
            for(int j : nums)
                cnt += (j & (1 << i)) != 0 ? 1 : -1;
            if(cnt > 0)
                candid |= 1 << i;
        }
        return candid;
    }
}
