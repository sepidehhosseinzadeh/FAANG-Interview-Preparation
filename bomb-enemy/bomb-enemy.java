class Solution {
    public int maxKilledEnemies(char[][] g) {
        if(g.length == 0) return 0;
        int n = g.length, m = g[0].length;
        int row = 0; int[] col = new int[m];
        int max = 0;
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++) { // put bomb at i,j
                if(i == 0 || g[i-1][j] == 'W') {
                    col[j] = 0;
                    for(int k = i; k < n && g[k][j]!='W'; k++) 
                        if(g[k][j]=='E') col[j]++;
                }
                if(j == 0 || g[i][j-1] == 'W') {
                    row = 0;
                    for(int k = j; k < m && g[i][k]!='W'; k++) 
                        if(g[i][k]=='E') row++;
                }
                if(g[i][j] == '0')
                    max = Math.max(max, row+col[j]);
            }
        
        return max;
    }
}
