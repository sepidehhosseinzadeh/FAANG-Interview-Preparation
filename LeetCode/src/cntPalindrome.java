import java.util.*;

public class cntPalindrome {
	public int countSubstrings_v0(String ss) {
		int n = ss.length();
		char[] s = ss.toCharArray();
		int[][] dp = new int[n+1][n+1];
		int cnt = 0;

		for(int l = 1; l <= n; l++)
			for(int i = 0; i+l-1 < n; i++) {
				int j = i+l-1;
				if(i == j) {
					dp[i][j] = 1;
					cnt++;
				} else if(i+1 == j && s[i] == s[j]) {
					dp[i][j] = 2;
					cnt++;
				} else if(s[i] == s[j] && dp[i+1][j-1] > 0) {
					dp[i][j] = dp[i+1][j-1]+2;
					cnt++;
				}
			}

		return cnt;
	}

	public int countSubstrings(String ss) {
		int n = ss.length();
		char[] s = ss.toCharArray();
		boolean[][] isPalin = new boolean[n+1][n+1];
		int cnt = 0;

		for(int l = 1; l <= n; l++)
			for(int i = 0; i+l-1 < n; i++) {
				int j = i+l-1;
				isPalin[i][j] = s[i]==s[j] && (l <= 2 || isPalin[i+1][j-1]);
				if(isPalin[i][j]) cnt++;
			}
		return cnt;
	}
}