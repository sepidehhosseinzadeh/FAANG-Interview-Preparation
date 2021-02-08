class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int S = 0; for(int i: nums) S+=i; 
        if(S % 2 != 0) return false;
       
        S /= 2; // we need to build until S/2
        
        boolean[][] canBuild = new boolean[n+1][S+1]; 
        
        for(int i = 0; i <= n; i++)
            canBuild[i][0] = true;
        
        for(int i = 1; i <= n; i++)
            for(int s = 1; s <= S; s++) {
                canBuild[i][s] = canBuild[i-1][s];
                if(s >= nums[i-1]) canBuild[i][s] |= canBuild[i-1][s-nums[i-1]];
            }
        
        return canBuild[n][S];
    }
}