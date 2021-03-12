class Solution {
    int n, m, cnt;
    int[] d = new int[] {0,1,0,-1,0};
    public int maxAreaOfIsland(int[][] g) {
        n = g.length; m = g[0].length;
        int max = 0;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(g[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j, g);
                    max = Math.max(max, cnt);
                }
        
        return max;
    }
    void dfs(int x, int y, int[][] g) {
        g[x][y] = -1;
        cnt++;
        for(int i = 0; i < 4; i++) {
            int tx = x+d[i], ty = y+d[i+1];
            if(tx>=0 && ty>=0 && tx < n && ty < m && g[tx][ty]==1)
                dfs(tx,ty,g);
        }
    }
}
