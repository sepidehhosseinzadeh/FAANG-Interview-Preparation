import java.util.*;

/*
Shortest Path in a Grid with Obstacles Elimination

Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle).
In one step, you can move up, down, left or right from and to an empty cell.

Return the minimum number of steps to walk from the upper left corner (0, 0)
to the lower right corner (m-1, n-1), given that you can eliminate at most k obstacles.
If it is not possible to find such walk return -1.
 */
public class minStepKblock
{
    public int shortestPath(int[][] grid, int k)
    {
        int n = grid.length, m = grid[0].length;
        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] vis = new boolean[n][m][k + 1];

        q.add(new int[]{0, 0, 0, grid[0][0]});
        vis[0][0][grid[0][0]] = true;

        while (!q.isEmpty())
        {
            int[] at = q.remove();
            int ax = at[0], ay = at[1], as = at[2], ac = at[3];
            if (ax == n - 1 && ay == m - 1) return as;

            for (int i = 0; i < 4; i++)
            {
                int tx = ax + d[i][0], ty = ay + d[i][1];
                if (tx < 0 || ty < 0 || tx >= n || ty >= m) continue;

                int tc = ac + grid[tx][ty];

                if (tc > k || vis[tx][ty][tc]) continue;

                vis[tx][ty][tc] = true;
                q.add(new int[]{tx, ty, as + 1, tc});
            }
        }

        return -1;
    }
}


