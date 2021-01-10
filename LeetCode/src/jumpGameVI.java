import java.util.*;

public class jumpGameVI {
	public int maxResult_v0(int[] nums, int k) {
		int n = nums.length, max = 0;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = nums[0];

		// From i+1 to i+k, we care about jumping to positive vals
		// if all are negative, we have to jump somewhere, so
		// jump to the max one
		for(int i = 0; i < n; i++)
			for(int j = 1; j <= k && i+j < n; j++) {
				dp[i+j] = Math.max(dp[i+j], dp[i] + nums[i+j]);
				if(nums[i+j] >= 0) break;
				// when found a positive val, we definitly take it,
				// and don't need to jump further.
			}

		return dp[n-1];
	}

	// bfs is TLE! becuz it adds to indice to q. And it may add
	// k indice for every n index -> o(E V)=o(nk)
	// next approach is deque sliding window, the difference is
	// for each at position, it pops the max previous value within k length window
	// in o(1) (always las elem), so o(n)
	public int maxResult_v1(int[] nums, int k) {
		int n = nums.length, max = Integer.MIN_VALUE;
		Deque<int[]> q = new ArrayDeque<>();
		q.addLast(new int[]{0,nums[0]});

		while(!q.isEmpty()) {
			int[] at = q.removeLast();
			if(at[0] == n-1) max = Math.max(max, at[1]);

			// remove unnessary idx < k distand
			while(!q.isEmpty() && q.peekFirst()[0] < at[0]-k)
				q.removeFirst();

			int maxNeg = Integer.MIN_VALUE, J = -1;
			boolean foundPos = false;
			for(int j = 1; j <= k && at[0]+j < n; j++) {
				int to = at[0]+j, toS = at[1]+nums[to];
				if(nums[to] >= 0) {
					q.addLast(new int[]{to, toS});
					foundPos = true;
				} else if(maxNeg < nums[to]){
					maxNeg = nums[to]; J = j;
				}
			}
			if(!foundPos && at[0] < n-1) {
				q.addLast(new int[]{at[0]+J,at[1]+maxNeg});
			}

		}
		return max;
	}

	// o(nlogn)
	public int maxResult(int[] nums, int k) {
		int n = nums.length;
		int[] score = new int[n];
		score[0] = nums[0];
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		priorityQueue.add(new int[] { nums[0], 0 });
		for (int i = 1; i < n; i++) {
			// pop the old index
			while (priorityQueue.peek()[1] < i - k) {
				priorityQueue.remove();
			}
			score[i] = nums[i] + score[priorityQueue.peek()[1]];
			priorityQueue.add(new int[] { score[i], i });
		}
		return score[n - 1];
	}

	// o(n)
	public int maxResult_v2(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> dq = new LinkedList<>();
		int[] best = new int[n];
		Arrays.fill(best,Integer.MIN_VALUE);

		dq.offer(0);
		best[0] = nums[0];

		for(int i = 1; i < n; i++) {
			// rm old index from left - make sure new idx add to right
			while(!dq.isEmpty() && dq.peekFirst() < i-k)
				dq.pollFirst();

			best[i] = best[dq.peekFirst()]+nums[i];

			// rm smaller vals from right and add the cur val
			// make sure to have a monotonically decreasing q
			while(!dq.isEmpty() && best[dq.peekLast()] <= best[i])
				dq.pollLast();

			// new idx add to right
			dq.offerLast(i);
		}

		return best[n-1];
	}
}
