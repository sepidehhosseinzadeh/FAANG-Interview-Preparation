import java.util.*;

public class intervalMerge {
	public int[][] merge(int[][] in) {
		Arrays.sort(in, (i, j) -> i[0] - j[0]);
		int n = in.length;
		var res = new ArrayList<int[]>();
		int i = 1;
		int[] cur = in[0].clone();

		while (i < n) {
			if (cur[1] < in[i][0]) {
				res.add(cur.clone());
				cur = in[i].clone();
			} else if (cur[0] > in[i][1]) {
				res.add(in[i].clone());
			} else {
				cur = new int[]{Math.min(cur[0], in[i][0]),
						Math.max(cur[1], in[i][1])};
			}
			i++;
		}
		res.add(cur);

		i = 0;
		int[][] ret = new int[res.size()][2];
		for (int[] j : res) ret[i++] = j;
		return ret;
	}
}