import java.util.*;

public class pickCherries {
    int[][][][] memo;
    int inf = Integer.MAX_VALUE;

    public int cherryPickup(int[][] g) {
        int n = g.length;
        memo = new int[n][n][n][n];
        for (int[][][] i : memo)
            for (int[][] j : i)
                for (int[] k : j) Arrays.fill(k, -inf);

        return Math.max(0, maxCherries(0, 0, 0, 0, n, g));
    }

    int maxCherries(int ax1, int ay1, int ax2, int ay2, int n, int[][] g) {
        if (ax1 >= n || ay1 >= n || ax1 < 0 || ay1 < 0 ||
                ax2 >= n || ay2 >= n || ax2 < 0 || ay2 < 0 ||
                g[ax1][ay1] < 0 || g[ax2][ay2] < 0)
            return -inf;

        // If one of them reached end, ignore the other one! It's like
        // one person went from 0,0 to n-1,n-1, and came back to 0,0 by SAME PATH
        if (ax1 == n - 1 && ay1 == n - 1)
            return g[ax1][ay1];
        if (ax2 == n - 1 && ay2 == n - 1)
            return g[ax2][ay2];

        if (memo[ax1][ay1][ax2][ay2] != -inf)
            return memo[ax1][ay1][ax2][ay2];

        int pick = g[ax1][ay1] + g[ax2][ay2];
        if (ax1 == ax2 && ay1 == ay2) pick = g[ax1][ay1];

        int a = maxCherries(ax1 + 1, ay1, ax2 + 1, ay2, n, g);
        int b = maxCherries(ax1 + 1, ay1, ax2, ay2 + 1, n, g);
        int c = maxCherries(ax1, ay1 + 1, ax2 + 1, ay2, n, g);
        int d = maxCherries(ax1, ay1 + 1, ax2, ay2 + 1, n, g);

        return memo[ax1][ay1][ax2][ay2] =
                pick + Math.max(a, Math.max(b, Math.max(c, d)));
    }
}