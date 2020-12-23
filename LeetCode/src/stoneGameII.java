import java.util.*;

public class stoneGameII {
	public int stoneGameII(int[] stone) {
		int n = stone.length;

		int[] preSum = new int[n+1];
		for(int i = n-1; i >= 0; i--)
			preSum[i] = stone[i]+preSum[i+1];

		int[][] dp = new int[n+1][n+1]; // maxCoins Alice can get when starts at i,
		// with M = j coins
		for(int i = 0; i < n; i++) // in any position i, if M=n, optimally I take all
			dp[i][n] = preSum[i];

		for(int i = n-1; i >= 0; i--)
			for(int j = n-1; j >= 1; j--) {
				for(int x = 1; x <= 2*j && i+x <= n; x++) // play optimally each run for each person (dp)!
					// so max(current coins I can get + next round coins : rest_sum - opponent's coins)
					dp[i][j] = Math.max(dp[i][j],
							preSum[i]-preSum[i+x] + preSum[i+x]-dp[i+x][Math.max(x,j)]);
			}

		return dp[0][1];
	}
}
