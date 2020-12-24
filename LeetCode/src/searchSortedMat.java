import java.util.*;

public class searchSortedMat {
	// o(log n + log m)
	public boolean searchMatrix_v0(int[][] mat, int t) {
		int n = mat.length, m = mat[0].length;

		// find the biggest less eq t in col 0
		int lb = 0, ub = n-1;
		while(lb <= ub) { // = for 1 element
			int mid = lb + (ub-lb)/2;
			if(mat[mid][0] == t) return true;
				// found the appropriate row
			else if(mat[mid][0] < t &&
					(mid+1==n || mat[mid+1][0] >= t)) {
				if(mid+1 < n && mat[mid+1][0]==t) return true;
				lb = mid;
				break;
			}
			else if(mat[mid][0] < t) lb = mid+1; // if less only
			else ub = mid-1;
		}
		// lb is the row to search for
		int r = lb;
		lb = 0; ub = m-1;
		while(lb < ub) {
			int mid = lb + (ub-lb)/2;
			if(mat[r][mid] == t) return true;
			else if(mat[r][mid] < t) lb = mid+1;
			else ub = mid-1;
		}
		return mat[r][lb] == t; // check if the last one is t
	}

	// o(log(n*m)) treat the whole mat as one array
	public boolean searchMatrix_v1(int[][] mat, int t) {
		int n = mat.length, m = mat[0].length;

		int lb = 0, ub = n*m-1;
		while(lb <= ub) { // = for one elem
			int mid = lb+(ub-lb)/2;
			if(mat[mid/m][mid%m] == t) return true;
			else if(mat[mid/m][mid%m] < t) lb = mid+1;
			else ub = mid-1;
		}
		return false;
	}

	// o(n+m)
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0, j = matrix[0].length-1;
		while (i < matrix.length && j >= 0)
			if (matrix[i][j] == target) return true;
			else if (matrix[i][j] > target) j--;
			else i++;

		return false;
	}
}

