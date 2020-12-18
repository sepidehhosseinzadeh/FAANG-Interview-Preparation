import java.util.*;

public class longestPalindrome {
	public String longestPalindrome(String ss) {
		int n = ss.length();
		char[] s = ss.toCharArray();
		boolean[][] dp = new boolean[n+1][n+1];
		String res = "";
		for(int l = 1; l <= n; l++)
			for(int i = 0; i+l-1 < n; i++) {
				int j = i+l-1;
				dp[i][j] = s[i]==s[j] && (j-i <= 1 || dp[i+1][j-1]);
				if(dp[i][j] && res.length() < j-i+1) res = ss.substring(i, j+1);
			}
		return res;
	}

	//o(n^2) o(n^2)
	public String longestPalindrome_v1(String ss) {
		int n = ss.length();
		char[] s = ss.toCharArray();
		int[][] dp = new int[n+1][n+1];
		int maxLen = 0;
		String res = "";

		for(int l = 1; l <= n; l++)
			for(int i = 0; i+l-1 < n; i++) {
				int j = i+l-1;
				if(i == j) {
					dp[i][j] = 1;
					if(res.length() < dp[i][j])
						res = s[i]+"";
				} else if(i+1 == j && s[i] == s[j]) {
					dp[i][j] = 2;
					if(res.length() < dp[i][j])
						res = s[i]+""+s[i+1];
				} else if(s[i] == s[j] && dp[i+1][j-1] > 0) {
					dp[i][j] = dp[i+1][j-1]+2;
					if(res.length() < dp[i][j])
						res = ss.substring(i,j+1);
				}
			}

		return res;

	}

	//o(n^2) o(1)
	public String longestPalindrome_v2(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
}