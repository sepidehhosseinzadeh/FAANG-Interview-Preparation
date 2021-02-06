class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] preS = new int[n+1];
        for(int i = 1; i <= n; i++)
            preS[i] = preS[i-1]+nums[i-1];
        Arrays.sort(preS);
        return Math.abs(preS[0]-preS[n]);
    }
}