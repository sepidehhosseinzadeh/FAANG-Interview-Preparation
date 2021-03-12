class Solution {
    // idea is like topoligical sort
    // DFS with memo
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
    
    // DAG degree
    public int longestIncreasingPath_v1(int[][] matrix) {
        // Corner cases
        if (matrix.length == 0) {
            return 0;
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rows = matrix.length, cols = matrix[0].length;
        
        // indegree[i][j] indicates thee number of adjacent cells bigger than matrix[i][j]
        int[][] indegree = new int[rows][cols];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                for (int[] dir: dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                        if (matrix[nx][ny] > matrix[x][y]) {
                            indegree[x][y]++;
                        }
                    }
                }
            }
        }
        
        // Add each cell with indegree zero to the queue
        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (indegree[x][y] == 0) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        
        int length = 0; // The longest path so far
        // BFS implements the Topological Sort
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir: dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                        if (matrix[nx][ny] < matrix[x][y] 
                            && --indegree[nx][ny] == 0) {
                           queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            length++;
        }
        
        return length;
    }
}
