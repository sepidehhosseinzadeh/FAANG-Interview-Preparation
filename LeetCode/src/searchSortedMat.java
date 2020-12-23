import java.util.*;

public class searchSortedMat {
	public boolean searchMatrix_v0(int[][] mat, int t) {
		int n = mat.length, m = mat[0].length;
		int i = n-1, j = 0;

		while(i >= 0 && j < m) {
			if(mat[i][j] == t) return true;
			if(mat[i][j] > t) i--;
			else if(mat[i][j] < t) j++;
		}
		return false;
	}
}
