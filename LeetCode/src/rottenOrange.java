import java.util.*;

public class rottenOrange {
	int n, m;
	int[] d = new int[]{0,1,0,-1,0};
	public int orangesRotting(int[][] grid) {
		n = grid.length; m = grid[0].length;
		int fresh = 0;
		var q = new LinkedList<int[]>();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(grid[i][j] == 2)
					q.add(new int[]{i,j, 0}); // x,y, min
				else if(grid[i][j] == 1) fresh++;

		int t = 0;
		while(!q.isEmpty()) {
			int[] at = q.remove();
			t = Math.max(t, at[2]);

			for(int i = 0; i < 4; i++) {
				int tox = at[0]+d[i], toy = at[1]+d[i+1];
				if(tox < 0 || toy < 0 || tox >= n || toy >= m) continue;
				if(grid[tox][toy] != 1) continue;

				fresh--;
				grid[tox][toy] = 2;
				q.add(new int[]{tox,toy,at[2]+1});
			}
		}

		return fresh > 0 ? -1 : t;
	}
}