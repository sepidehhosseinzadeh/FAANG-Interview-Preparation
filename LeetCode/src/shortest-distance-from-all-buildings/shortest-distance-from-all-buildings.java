class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0) return -1;
        int n = grid.length, m = grid[0].length;
        
        int[][] dis = new int[n][m]; // dis[i][j] = sum dis from every 0 to building
        int[][] reach = new int[n][m]; // count num of buildings reached from 0
        
        // min dis that reach is num of buildings
        int minD = Integer.MAX_VALUE, nB = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) 
                if(grid[i][j] == 1) {
                    bfs(i,j, nB, grid, dis, reach);  
                    nB++;
                }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == 0 && reach[i][j] == nB)
                    minD = Math.min(minD, dis[i][j]);
        
        return minD == Integer.MAX_VALUE ? -1 : minD;
    }
    
    private void bfs(int x, int y, int nB, int[][] g, int[][] dis, int[][] reach) {
        int n = dis.length, m = dis[0].length;
        int[] d = new int[] {0,1,0,-1,0};
        
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {x,y});
        
        int level = 1;
        
        while(!q.isEmpty()) {
            int nQ = q.size(); // all childs have dis level
            
            for(int i = 0; i < nQ; i++) {
                int[] at = q.poll();
                for(int k = 0; k < 4; k++) {
                    int tx = at[0]+d[k], ty = at[1]+d[k+1];
                    if(tx<0 || ty<0 || tx>=n || ty >=m) continue;
                    if(g[tx][ty] == 0 && reach[tx][ty] == nB) {
                        q.add(new int[] {tx,ty});

                        dis[tx][ty] += level;
                        reach[tx][ty]++;
                    }
                }
            }
            level++;
        }
    }
}
