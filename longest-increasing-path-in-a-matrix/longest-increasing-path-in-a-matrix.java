class Solution {
    int[] d = new int[] {0,1,0,-1,0};
    int n,m;
    public int longestIncreasingPath(int[][] mat) {
        n = mat.length; m = mat[0].length;
        int maxLen = 0;
        int[][] memo = new int[n][m];
        for(int i[]: memo) Arrays.fill(i, -1);
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                int len = dfs(i,j, mat[i][j], mat, memo);
                maxLen = Math.max(maxLen, len);
            }
        
        return maxLen;
    }
    int dfs(int x, int y, int max, int[][] mat, int[][] memo) {
        if(memo[x][y] != -1) return memo[x][y];
        
        int maxLen = 1;
        for(int i = 0; i < 4; i++) {
            int tx = x+d[i], ty = y+d[i+1];
            if(tx >= 0 && ty >=0 && tx < n && ty < m && mat[tx][ty] > max) {
                maxLen = Math.max(maxLen, 
                        1+dfs(tx,ty, Math.max(max, mat[tx][ty]), mat, memo));
            }
        }
        
        return memo[x][y] = maxLen;
    }
}
​
