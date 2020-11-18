import java.util.*;

class wordBreak {
    int memo[];
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo,-1);

        var dic = new HashSet<String>();
        for(String str : wordDict) dic.add(str);

        //return wordBreak(0, s, dic);
        return wordBreakDP(s,dic);
    }
    boolean wordBreak(int at, String s, HashSet<String> dic)
    {
        if(at >= s.length()) return true;
        if(memo[at]!=-1) return memo[at]==1; // cannot be used!!

        for(int i = at; i < s.length(); i++)
            if(dic.contains(s.substring(at,i+1)) &&
                    (i+1== s.length() || wordBreak(i+1, s, dic)))
                return true;

        return false;

    }

    boolean wordBreakDP_v0(String s, HashSet<String> dic)
    {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int l = 0; l < n; l++)
            for (int i = 0; i+l < n; i++)
            {
                int j = i + l;
                dp[i][j] |= dic.contains(s.substring(i, j+1));
                if(dp[i][j]) continue;

                for(int k = i; k+1 <= j; k++)
                    if(dp[i][k] && dp[k+1][j]) {
                        dp[i][j] = true;
                        break;
                    }
            }
        return dp[0][n-1];
    }
    // I don't need to check dp[i][j], becuz whole str should be separable, so check dp[i] till i
    boolean wordBreakDP(String s, HashSet<String> dic)
    {
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0] = true;
        for (int i = 0; i <= n; i++)
            for(int j = 0; j <= i; j++)
                if(dp[j] && dic.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
        return dp[n];
    }
}
