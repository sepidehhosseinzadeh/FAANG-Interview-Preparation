import java.util.*;

// first approach: (like mergeSort) divide and conqur
public class skyLine {
	public List<List<Integer>> getSkyline(int[][] b) {
		List<List<Integer>> res = new ArrayList<>();
		// lesser x and lesser h comes first (cuz -h is start and we want start come first)
		PriorityQueue<int[]> q =
				new PriorityQueue<>((i,j) -> i[0]!=j[0] ? i[0]-j[0] : i[1]-j[1]);
		for(int[] i : b) {
			q.add(new int[] {i[0], -i[2]});
			q.add(new int[] {i[1], i[2]});
		}

		// track if adding new elem will change the max h or not, if yes, add to res
		PriorityQueue<Integer> dh = new PriorityQueue<>((i,j) -> j-i);
		dh.add(0);
		while(!q.isEmpty()) {
			int x = q.peek()[0], h = q.poll()[1];

			int h1 = dh.peek();
			if(h < 0) dh.add(-h);
			else dh.remove(h);
			int h2 = dh.peek();

			if(h1 != h2) res.add(Arrays.asList(x, h2));
		}

		return res;
	}
}