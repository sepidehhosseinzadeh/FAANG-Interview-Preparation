class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] =
            skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        int cnt = 0;
        boolean[] vis = new boolean[10];
        for(int i = m; i <= n; i++) { 
            cnt += dfs(1, i, skip, new boolean[10])*4; // 1,3,7,9 (corners) are symmetric
            cnt += dfs(2, i, skip, new boolean[10])*4; // 2,4,6,8
            cnt += dfs(5, i, skip, new boolean[10]); // 5
        }
        // for(int i = m; i <= n; i++) 
        //     for(int j = 1; j < 10; j++)
        //         cnt += dfs(j, i, skip, new boolean[10]);
        return cnt;
    }
    private int dfs(int at, int len, int[][] skip, boolean[] vis) {
        if(len == 1) return 1;
        
        int cnt = 0;
        
        vis[at] = true;
        for(int i = 1; i < 10; i++) {
            if(!vis[i])
                if(skip[at][i] == 0 || vis[ skip[at][i] ])//knight jump is condition-free
                    cnt += dfs(i, len-1, skip, vis);
        }
        vis[at] = false;
        
        return cnt;
    }
}