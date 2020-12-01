import java.util.*;

class pickCherries {
    int[][][] memo;
    int inf = Integer.MAX_VALUE;

    public int cherryPickup_v0(int[][] g) {
        int n = g.length;
        memo = new int[n][n][n];
        for (int[][] i : memo)
            for (int[] j : i) Arrays.fill(j, -inf);

        return Math.max(0, maxCherries(0,/*0,*/0, 0, n, g));
    }

    // ax1+ay1 = ax2+ay2
    // ay1 = ax2+ay2-ax1
    int maxCherries(int ax1, /*int ay1,*/ int ax2, int ay2, int n, int[][] g) {
        int ay1 = ax2 + ay2 - ax1;
        if (ax1 >= n || ay1 >= n || ax1 < 0 || ay1 < 0 ||
                ax2 >= n || ay2 >= n || ax2 < 0 || ay2 < 0 ||
                g[ax1][ay1] < 0 || g[ax2][ay2] < 0)
            return -inf;

        // check if we reached the end state
        // ***** note that if r1,c1 reached the end,
        // this implies that r2,c2 also reached the end, becuz ax1+ay1 = ax2+ay2

        if (ax1 == n - 1 && ay1 == n - 1)
            return g[ax1][ay1];

        if (memo[ax1][ax2][ay2] != -inf)
            return memo[ax1][ax2][ay2];

        int pick = g[ax1][ay1] + g[ax2][ay2];
        if (ax1 == ax2 && ay1 == ay2) pick = g[ax1][ay1];

        int a = maxCherries(ax1 + 1, /*ay1,*/ ax2 + 1, ay2, n, g);
        int b = maxCherries(ax1 + 1, /*ay1,*/ ax2, ay2 + 1, n, g);
        int c = maxCherries(ax1, /*ay1+1,*/ ax2 + 1, ay2, n, g);
        int d = maxCherries(ax1, /*ay1+1,*/ ax2, ay2 + 1, n, g);

        return memo[ax1][ax2][ay2] =
                pick + Math.max(a, Math.max(b, Math.max(c, d)));
    }
    // Instead of going once from 0,0 to n-1,n-1 and then back, we simply go,n-1
    // because every path from n-1,n-1 to 0,0 can be interpreted as a path from
    // 0,0 to n-1,n-1.

    // ******* Note******* that the one person can never cross the past path of
    // the other person (they can only meet at the same position)
    // so we don't need to worry about one person picking up an already picked up
    // cherry from the past.
    // What does a state represent?
    // dp[r1][c1][c2] represents the max number of cherries that can be collected by 2 people going
    // from r1,c1 and r2,c2 to n-1,n-1
    // Transitions between states?
    // we collect cherries on current positions of the two people
    // (r1,c1 and r2,c2), then we go through all possible next states and
    // choose the best one (max number of cherries) as the next state
    // (we do this by adding the number of cherries of the best next state to
    // the number of cherries we picked up on the current two positions
    // of the people).


    // DP
    public int cherryPickup(int[][] g) {
        int n = g.length;
        int[][][] dp = new int[n+1][n+1][n+1];
        for (int[][] i : dp)
            for (int[] j : i) Arrays.fill(j, -inf);

        dp[1][1][1] = g[0][0];
        for(int x1 = 1; x1 <= n; x1++)
            for(int x2 = 1; x2 <= n; x2++)
                for(int y2 = 1; y2 <= n; y2++)
                {
                    int y1 = x2+y2-x1;
                    if(y1 < 1 || y1 > n) continue;
                    if(g[x1-1][y1-1] < 0 || g[x2-1][y2-1] < 0) continue;

                    int pick = g[x1-1][y1-1] + g[x2-1][y2-1]; // work w idx-1
                    if (x1 == x2 && y1 == y2) pick = g[x1-1][y1-1];

                    dp[x1][x2][y2] =  Math.max(dp[x1][x2][y2], // possible to revisit
                            pick+Math.max(dp[x1-1][x2-1][y2],
                                    Math.max(dp[x1-1][x2][y2-1],
                                            Math.max(dp[x1][x2-1][y2],
                                                    dp[x1][x2][y2-1]))));
                }

        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }

}

