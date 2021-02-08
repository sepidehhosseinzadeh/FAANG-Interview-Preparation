class Solution {
    public int minDistance(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = i;
        for(int i = 0; i <= m; i++)
            dp[0][i] = i;
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++) 
                if(w1.charAt(i-1) == w2.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1];
                else 
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], 
                                       Math.min(dp[i-1][j], dp[i][j-1]));
                
        return dp[n][m];
    }
}