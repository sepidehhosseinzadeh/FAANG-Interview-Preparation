import java.util.*;

// https://leetcode.com/problems/path-with-minimum-effort/
public class minMaxCostDP {
    public int minimumEffortPath(int[][] h) {
        minD = Integer.MAX_VALUE;
        dfs(0,0,h,new boolean[h.length][h[0].length], 0);
        return minD;
    }
    int[] dx = new int[] {1,-1,0,0};
    int[] dy = new int[] {0,0,1,-1};
    int minD;
    void dfs(int atx, int aty, int[][] h, boolean[][] vis, int maxD)
    {
        //vis[atx][aty] = true;
        if(atx == h.length-1 && aty == h[0].length-1)
        {
            minD = Math.min(minD, maxD);
            return;
        }
        for(int i = 0; i < 4; i++)
        {
            int tx = atx+dx[i], ty = aty+dy[i];
            if(tx < 0 || ty < 0 || tx >= h.length || ty >= h[0].length) continue;
            if(vis[tx][ty]) continue;

            vis[tx][ty] = true;
            dfs(tx,ty,h,vis,Math.max(maxD, Math.abs(h[tx][ty]-h[atx][aty])));
            vis[tx][ty] = false;
        }

        //vis[atx][aty] = false;
    }
}
