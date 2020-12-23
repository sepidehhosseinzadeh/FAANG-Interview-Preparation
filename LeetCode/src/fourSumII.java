import java.util.*;

public class fourSumII {
	// we can observe that a + b == -(c + d).
	// First, we will count sums of elements a + b from the first two arrays using a hashmap.
	// Then, we will enumerate elements from the third and fourth arrays,
	// and search for a complementary sum a + b == -(c + d) in the hashmap.
	public int fourSumCount_v0(int[] A, int[] B, int[] C, int[] D) {
		int target = 0;
		var allComb = new HashMap<Integer,Integer>();
		for(int i : A)
			for(int j : B)
				allComb.put(i+j, allComb.getOrDefault(i+j,0)+1);
		int cnt = 0;
		for(int i : C)
			for(int j: D)
				if(allComb.containsKey(target-(i+j)))
					cnt += allComb.get(target-(i+j));
		return cnt;
	}

	// o(n^0.5): using same idea above, we can use n/2 lists to have all combinations of sums,
	// then use the other n/2 to enumerate and check target-currSumOfthisHalf exists in map?
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int[][] mat = new int[4][A.length];
		mat[0] = A; mat[1] = B; mat[2] = C; mat[3] = D;

		var allComb = new HashMap<Integer,Integer>();
		allCombSum(0,0,allComb,mat);

		return countComplement(mat.length/2, 0, 0, allComb, mat);

	}
	void allCombSum(int at, int curSum, HashMap<Integer, Integer> allComb, int[][] lists) {
		if(at == lists.length/2) {
			allComb.put(curSum, allComb.getOrDefault(curSum,0)+1);
			return;
		}

		for(int num : lists[at])
			allCombSum(at+1, curSum+num, allComb, lists);
	}
	int countComplement(int at, int target, int curSum,
						HashMap<Integer, Integer> allComb, int[][] lists) {
		if(at == lists.length) return allComb.getOrDefault(target-curSum, 0);

		int cnt = 0;
		for(int num : lists[at])
			cnt += countComplement(at+1, target, curSum+num, allComb, lists);
		return cnt;
	}

	// this function is for merging 4 arrays!!!! wrong!!!! for this question!!!
	public int fourSumCount_v111(int[] A, int[] B, int[] C, int[] D) {
		if(A.length == 0) return 0;

		Arrays.sort(A);Arrays.sort(B);Arrays.sort(C);Arrays.sort(D);
		int[][] mat = new int[4][A.length];
		mat[0] = A; mat[1] = B; mat[2] = C; mat[3] = D;

		var q = new PriorityQueue<int[]>((i,j) -> i[0]-j[0]); //val,idx
		for(int i = 0; i < 4; i++)
			q.add(new int[]{mat[i][0], i, 0});

		int cnt = 0;
		while(!q.isEmpty()) {
			int[][] v = new int[4][3];

			for(int i = 0; i < 4; i++)
				if(!q.isEmpty()) v[i] = q.poll();

			int sum = 0;
			for(int j = 0; j < 4; j++)
				sum += v[j][0];

			if(sum == 0) cnt++;

			boolean has = false;
			int i;
			for(i = 0; i < 4; i++)
				if(v[i][2]+1 < A.length) {
					q.offer(new int[]{mat[v[i][1]][v[i][2]+1], v[i][1], v[i][2]+1});
					has = true;
					break;
				}

			if(!has) break;

			for(int j = 0; j < 4; j++)
				if(j != i)
					q.offer(v[j]);
		}

		return cnt;
	}
}
