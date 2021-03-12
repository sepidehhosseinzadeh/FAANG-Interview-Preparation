class Solution {
    // hashmap cnt for counting different pairs for a specific mult
    // choose(m,2) * 2!*2!*2! different ways of 2 pairs-each pair 2! and 2 pair can switch side. 
    // nums = [2,3,4,6] : 
    // (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
    // (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2) 
    public int tupleSameProduct(int[] nums) {
        Map<Long, Integer> cnt = new HashMap<>();
​
        int n = nums.length;
        for(int i = 0; i < n; i++)
            for(int j = i+1; j < n; j++) {
                long m = (long) nums[i] * nums[j];
                cnt.put(m, cnt.getOrDefault(m,0)+1);
            }
​
        int res = 0;
        for(long m : cnt.keySet())
            if(cnt.getOrDefault(m, 0) > 1)
                res += cnt.getOrDefault(m, 0)*(cnt.getOrDefault(m, 0)-1)/2*8; 
        
        return res;
    }
    
    public int tupleSameProduct_v0(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += 8 * map.getOrDefault(nums[i] * nums[j], 0);
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        
        return ans;
    }
}
