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

	// T(nm) = 3T(nm/4) + n^0 -> o(nm^log4(3))
	public boolean searchMatrix(int[][] mat, int target) {
		return searchMat(mat, target, 0,0,mat.length-1,mat[0].length-1);
	}
	boolean searchMat(int[][] mat, int t, int lr, int lc, int ur, int uc) {
		if(lr > ur || lc > uc || ur < 0 || uc < 0 ||
				lr >= mat.length || lc >= mat[0].length) return false;
		if(lc == uc && lr == ur) return mat[lr][lc] == t;

		int mr = lr+(ur-lr)/2, mc = lc+(uc-lc)/2;
		if(mat[mr][mc] == t) return true;
		else if(mat[mr][mc] < t) {
			return searchMat(mat,t, lr, mc+1, mr,uc) ||
					searchMat(mat,t, mr+1, lc, ur, mc) ||
					searchMat(mat,t, mr+1,mc+1, ur,uc); // get upperbound cuz /2
		} else {
			return searchMat(mat,t, lr, mc, mr-1,uc) ||
					searchMat(mat,t, mr, lc, ur, mc-1) ||
					searchMat(mat,t, lr,lc, mr,mc);
		}
	}
}
