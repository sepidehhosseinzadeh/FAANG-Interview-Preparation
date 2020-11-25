import java.util.*;

public class robotGridWithObs {
    public int uniquePathsWithObstacles_v0(int[][] g) {
        int m = g.length, n = g[0].length;
        if (g[0][0] == 1 || g[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++)
            if (g[0][i] == 0 && dp[0][i - 1] == 1)
                dp[0][i] = 1; // if cur is not blocked and we could go to i-1!
        for (int i = 1; i < m; i++)
            if (g[i][0] == 0 && dp[i - 1][0] == 1)
                dp[i][0] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (g[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length, n = g[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
        return dp[n - 1];
    }
}