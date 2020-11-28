import java.util.*;

public class flowWater {
    public static void main(String[] args)
    {
        System.out.print(pacificAtlantic(new int[][]{{1,2,2,3,5}, {3,2,3,4,4},
                {2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }

    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    boolean dfs(int ax, int ay, int x, int y, int[][] G, boolean[][] visited)
    {
        if(ax == x || ay == y) return true;

        for(int i = 0; i < 4; i++) {
            int tx = ax+dx[i], ty = ay+dy[i];
            if(tx < 0 || ty < 0 || tx >= G.length || ty >= G[0].length) continue;
            if(visited[tx][ty]) continue;
            if(G[tx][ty] > G[ax][ay]) continue; // direction is different than BFS!!!
            visited[tx][ty] = true;
            if(dfs(tx,ty,x,y,G,visited)) return true;
        }
        return false;
    }
    public List<List<Integer>> pacificAtlantic_v0(int[][] G) {
        var res = new ArrayList<List<Integer>>();
        if(G.length == 0) return res;
        int n = G.length, m = G[0].length;

        for(int i = 0; i < G.length; i++)
            for(int j = 0; j < G[0].length; j++)
                if(dfs(i,j,0,0,G,new boolean[n][m]) &&
                        dfs(i,j,n-1, m-1,G,new boolean[n][m])) {
                    res.add(Arrays.asList(i,j));
                }
        return res;

    }
    public static List<List<Integer>> pacificAtlantic(int[][] G) {
        var res = new ArrayList<List<Integer>>();
        if(G.length == 0) return res;
        int n = G.length, m = G[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];
        var qpac = new LinkedList<Integer>();
        var qatl = new LinkedList<Integer>();

        for(int i = 0; i < n; i++) {
            qpac.offer(i); qpac.offer(0);
            qatl.offer(i); qatl.offer(m-1);
            pac[i][0] = true; atl[i][m-1] = true;
        }
        for(int i = 0; i < m; i++) {
            qpac.offer(0); qpac.offer(i);
            qatl.offer(n-1); qatl.offer(i);
            pac[0][i] = true; atl[n-1][i] = true;
        }
        // flow the water to see which cells are visited
        bfs(pac, qpac,G);
        bfs(atl, qatl,G);
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i,j));
        return res;
    }
    static void bfs(boolean[][] vis, Queue<Integer> q, int[][] G) {
        while(!q.isEmpty()) {
            int ax = q.poll(), ay = q.poll();

            for(int i = 0; i < 4; i++) {
                int tx = ax+dx[i], ty = ay+dy[i];
                if(tx < 0 || ty < 0 || tx >= G.length || ty >= G[0].length)
                    continue;
                if(G[tx][ty] < G[ax][ay]) continue; // direction is different than DFS!!!
                if(vis[tx][ty]) continue;
                vis[tx][ty] = true;
                q.offer(tx); q.offer(ty);
            }
        }
    }
}
