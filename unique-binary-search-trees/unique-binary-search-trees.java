class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int n_nodes = 2; n_nodes <= n; n_nodes++) 
            for(int n_left = 0; n_left < n_nodes; n_left++)
                dp[n_nodes] += dp[n_left]*dp[n_nodes-n_left-1];
        
        return dp[n];
    }
}