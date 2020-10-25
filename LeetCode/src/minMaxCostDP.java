import java.util.*;

// https://leetcode.com/problems/path-with-minimum-effort/
public class minMaxCostDP {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int minimumEffortPath(int[][] h) {
        int n = h.length, m = h[0].length;
        int lb = 0, ub = (int) 1e6;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            boolean[][] vis = new boolean[n][m];
            dfs(0, 0, h, vis, 0, mid);
            if (vis[n - 1][m - 1]) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }

    void dfs(int atx, int aty, int[][] h, boolean[][] vis, int curD, int d)
    {
        vis[atx][aty] = true;
        if (atx == h.length - 1 && aty == h[0].length - 1)
            return;

        for (int i = 0; i < 4; i++) {
            int tx = atx + dx[i], ty = aty + dy[i];
            if (tx < 0 || ty < 0 || tx >= h.length || ty >= h[0].length) continue;
            if (vis[tx][ty]) continue;

            int dis = Math.abs(h[tx][ty] - h[atx][aty]);
            if (dis <= d)
                dfs(tx, ty, h, vis, Math.max(curD, dis), d);
        }
    }
}
