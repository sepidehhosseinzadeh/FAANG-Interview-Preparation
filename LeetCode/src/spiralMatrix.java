import java.util.*;

public class spiralMatrix {
	int[][] dir = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
	public List<Integer> spiralOrder(int[][] mat) {
		List<Integer> res = new ArrayList<>();
		int n = mat.length, m = mat[0].length;

		int x = 0, y = 0;
		while(n > 0 && m > 0) {

			// -> from x,y len = m
			for(int j = 0; j < m; j++,y++) res.add(mat[x][y]);y--; // last -1 is extra

			n--; x++;
			// |v len n
			if(n == 0) break;
			for(int j = 0; j < n; j++,x++) res.add(mat[x][y]);x--;

			m--; y--;
			// <- len m
			if(m == 0) break;
			for(int j = 0; j < m; j++,y--) res.add(mat[x][y]);y++;

			n--; x--;
			// |^
			if(n == 0) break;
			for(int j = 0; j < n; j++,x--) res.add(mat[x][y]);x++;

			m--;y++;
		}

		return res;
	}
}