import java.util.*;

public class rotate90 {
	public void rotate(int[][] mat) {
		int n = mat.length;

		for(int level=0,len=n-1,st=0; level<n/2; level++,len--,st++) {
			for(int i = st; i < len; i++) {
				int tmp = mat[level][i];  // tmp <- up
				mat[level][i] = mat[n-i-1][level]; // up <- left
				mat[n-i-1][level] = mat[n-level-1][n-i-1]; // left <- down
				mat[n-level-1][n-i-1] = mat[i][n-level-1]; // down <- right
				mat[i][n-level-1] = tmp; // right <- up
			}
		}
	}
}
