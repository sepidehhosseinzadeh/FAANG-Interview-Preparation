import java.util.*;

public class intervalMinDelToHaveNonOverlap {
	public int eraseOverlapIntervals(int[][] in) {
		if(in.length == 0) return 0;
		Arrays.sort(in, (i, j) -> i[0]!=j[0] ? i[0]-j[0] : i[1]-j[1]);
		int cnt = 0;
		int ub = in[0][1];

		for(int i = 1; i < in.length; i++) {
			if(ub > in[i][0]) { // overlap
				cnt++;
				ub = Math.min(ub, in[i][1]);
			} else
				ub = Math.max(ub, in[i][1]);
		}
		return cnt;
	}
}
