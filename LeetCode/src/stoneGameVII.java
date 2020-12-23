import java.util.*;

public class stoneGameVII {
	// memo o(2^(n^2)) for every element there is n sub-arr to check -> n^2 subarr
	// memo -> o(n^2)
	// Bob's goal is to return the minimize the difference (maximum negative value):
	// Bob's difference = Alice's difference - current Score
	// Alice's goal is to return the maximum positive value:
	// Alice's difference = Bob's difference + current Score
	public int stoneGameVII_v0(int[] stone) {
		int n = stone.length;

		memo = new int[n][n];
		for(int[] a : memo) Arrays.fill(a, -1);

		int[] preSum = new int[n+1];
		for(int i = 0; i < n; i++)
			preSum[i+1] = preSum[i]+stone[i];

		return Math.abs(play(0,n-1, preSum, true));
	}
	// alice takes l or r, tries to max diff
	// bob takes the one that min the diff
	int[][] memo;
	int play(int l, int r, int[] preSum, boolean alice) {
		if(l >= r) return 0;
		if(memo[l][r] != -1) return memo[l][r];
		// alice will try to win with maximize the diff of herself+bib'diff
		// + becuz bob's diff is a negative val
		if(alice)
			return memo[l][r]=Math.max((preSum[r+1]-preSum[l+1])+play(l+1,r,preSum,!alice),
					(preSum[r]-preSum[l])+play(l,r-1,preSum,!alice));
		else // bob will lose (always), try to minimize the alice's diff - himself's diff
			return memo[l][r]=Math.min(-(preSum[r+1]-preSum[l+1])+play(l+1,r,preSum,!alice),
					-(preSum[r]-preSum[l]) + play(l,r-1,preSum,!alice));
	}

	// DP o(n^2)
	public int stoneGameVII_v1(int[] stone) {
		int n = stone.length;
		int[] preSum = new int[n+1];
		for(int i = 0; i < n; i++)
			preSum[i+1] = preSum[i]+stone[i];

		int[][][] dp = new int[n][n][2];

		for(int len = 2; len <= n; len++)
			for(int l = 0; l+len-1 < n; l++) {
				int r = l+len-1;
				// alice
				dp[l][r][0] = Math.max((preSum[r+1]-preSum[l+1])+dp[l+1][r][1],
						(preSum[r]-preSum[l])+(r==0?0:dp[l][r-1][1]));
				dp[l][r][1] = Math.min(-(preSum[r+1]-preSum[l+1])+dp[l+1][r][0],
						-(preSum[r]-preSum[l])+(r==0?0:dp[l][r-1][0]));
			}
		return dp[0][n-1][0];
	}
	// Bob's goal is to return the minimize the difference (maximum negative value):
	// Bob's difference = Alice's difference - current Score
	// Alice's goal is to return the maximum positive value:
	// Alice's difference = Bob's difference + current Score
	// So, every person tries to maximize their own score!
	// Both Bob and Alice are trying to maximize their score.
	// Alice is trying to get the maximum score so that she has a maximum difference from Bob's score.
	// Bob is also trying to get the maximum score so that he is as close to Alice as possible.
	// difference = current Score - difference returned by opponent
	public int stoneGameVII_v2(int[] stone) {
		int n = stone.length;
		int[] preSum = new int[n+1];
		for(int i = 0; i < n; i++)
			preSum[i+1] = preSum[i]+stone[i];

		int[][] dp = new int[n][n];

		for(int len = 2; len <= n; len++)
			for(int l = 0; l+len-1 < n; l++) {
				int r = l+len-1;
				dp[l][r] = Math.max((preSum[r+1]-preSum[l+1])-dp[l+1][r],
						(preSum[r]-preSum[l])-(r==0?0:dp[l][r-1]));
			}
		return dp[0][n-1];
	}
	public int stoneGameVII(int[] stone) {
		int n = stone.length;
		int[] preSum = new int[n+1];
		for(int i = 0; i < n; i++)
			preSum[i+1] = preSum[i]+stone[i];

		int[][] dp = new int[n][n];

		for(int l = n-1; l >= 0; l--)
			for(int r = l+1; r < n; r++) {
				dp[l][r] = Math.max((preSum[r+1]-preSum[l+1])-dp[l+1][r],
						(preSum[r]-preSum[l])-(r==0?0:dp[l][r-1]));
			}
		return dp[0][n-1];
	}
}