class Solution {
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
}
