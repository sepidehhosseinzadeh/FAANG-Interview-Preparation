class Solution {
    // min abs sum
    public int minAbsoluteSum(int[] nums) { 
        int n = nums.length;
        int[] preS = new int[n+1];
        for(int i = 1; i <= n; i++)
            preS[i] = preS[i-1]+nums[i-1];
        Arrays.sort(preS);
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++)
            min = Math.min(min, Math.abs(preS[i]-preS[i-1]));
        
        return min;
    }
    
    // max abs sum
    public int maxAbsoluteSum_v0(int[] nums) {
        int n = nums.length;
        int[] preS = new int[n+1];
        for(int i = 1; i <= n; i++)
            preS[i] = preS[i-1]+nums[i-1];
        Arrays.sort(preS);
        return Math.abs(preS[0]-preS[n]);
    }
    public int maxAbsoluteSum(int[] A) {
        int s = 0, min = 0, max = 0;
        for (int a: A) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min;
    }
}
