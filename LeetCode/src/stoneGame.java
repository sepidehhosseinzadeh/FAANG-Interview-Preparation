import java.util.*;

public class stoneGame {
	public boolean stoneGame_v0(int[] stone) {
		int n = stone.length;
		int sum = 0; for(int i : stone) sum += i;

		int[][] dp = new int[n][n];
		for(int l = n-1; l >= 0; l--)
			for(int r = l+1; r < n; r++) {
				if(r == l)
					dp[l][r] = stone[l];
				else if(r == l+1)
					dp[l][r] = Math.max(stone[l], stone[r]);
				else
					dp[l][r] = Math.max(stone[l]+Math.min(dp[l+2][r], dp[l+1][r-1]),
							stone[r]+Math.min(dp[l][r-2], dp[l+1][r-1]));
			}
		return dp[0][n-1] > sum-dp[0][n-1];
	}
	// pass up the #stone you can save
	public boolean stoneGame_v1(int[] stone) {
		int n = stone.length;

		int[][] dp = new int[n][n];
		for(int l = n-1; l >= 0; l--)
			for(int r = l+1; r < n; r++)
				dp[l][r] = Math.max(stone[l]-dp[l+1][r], stone[r]-dp[l][r-1]);

		return dp[0][n-1] > 0;
	}
	// more memory efficient: 1D DP
	public boolean stoneGame_v2(int[] stone) {
		int n = stone.length;

		int[] dp = new int[n];
		for(int l = n-1; l >= 0; l--)
			for(int r = l+1; r < n; r++)
				dp[r] = Math.max(stone[l]-dp[r], stone[r]-dp[r-1]);

		return dp[n-1] > 0;
	}
	public boolean stoneGame(int[] stone) {
		return true;
	}
}
/* If the len of stones (piles) was even, Alex can always win!
Alex is first to pick pile.
piles.length is even, and this lead to an interesting fact:
Alex can always pick odd piles or always pick even piles!

For example,
If Alex wants to pick even indexed piles piles[0], piles[2], ....., piles[n-2],
he picks first piles[0], then Lee can pick either piles[1] or piles[n - 1].
Every turn, Alex can always pick even indexed piles and Lee can only pick odd indexed piles.

In the description, we know that sum(piles) is odd.
If sum(piles[even]) > sum(piles[odd]), Alex just picks all evens and wins.
If sum(piles[even]) < sum(piles[odd]), Alex just picks all odds and wins.

So, Alex always defeats Lee in this game.
*/
