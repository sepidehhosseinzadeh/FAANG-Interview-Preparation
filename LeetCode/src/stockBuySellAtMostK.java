import java.util.*;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution

public class stockBuySellAtMostK {
    // dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] maxProf = new int[K+1][n]; // maxProf[i]: max profit till i

        for(int k = 1; k <= K; k++)
            for(int i = 1; i < n; i++) { // sell
                maxProf[k][i] = maxProf[k][i-1]; // don't sell at i with k trans
                for(int j = 0; j < i; j++) // buy at j < i.
                    maxProf[k][i] = Math.max(maxProf[k][i],
                            prices[i]-prices[j]+(j>=1?maxProf[k-1][j-1]:0));
            }
        return maxProf[K][n-1];
    }
}
