import java.util.*;

public class minDelCostAvoidRepLetters {
	// o(nlogm)
	public int minCost_v0(String s, int[] cost) {
		int n = cost.length;
		if(n <= 1) return 0;

		int mcost = 0;
		var q = new PriorityQueue<Integer>();
		for(int i = 1; i < n; i++) {
			q.add(cost[i-1]);
			if(s.charAt(i-1) != s.charAt(i)) {
				while(q.size() > 1) mcost += q.remove();
				q.clear();
			}
		}
		if(!q.isEmpty()) {
			q.add(cost[n-1]);
			while(q.size() > 1) mcost += q.remove();
		}
		return mcost;
	}

	// o(n)
	// max is useless, cost += sum-maxElemCost
	public int minCost_v1(String s, int[] cost) {
		int n = cost.length;
		if(n <= 1) return 0;

		int mcost = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0, cnt = 0;
		for(int i = 1; i < n; i++) {
			sum += cost[i-1];
			max = Math.max(cost[i-1], max);
			cnt++;

			if(s.charAt(i-1) != s.charAt(i)) {
				if(cnt > 1) mcost += sum-max;
				sum = 0; cnt = 0;
				max = Integer.MIN_VALUE;
			}
		}
		if(sum > 0) {
			sum += cost[n-1];
			max = Math.max(cost[n-1], max);
			cnt++;
			if(cnt > 1) mcost += sum-max;
		}
		return mcost;
	}
	// o(n) cleaner, simpler
	public int minCost(String s, int[] cost) {
		int mcost = cost[0], max = cost[0];

		for(int i = 1; i < cost.length; i++) {
			if(s.charAt(i-1) != s.charAt(i)) {
				mcost -= max;
				max = 0;
			}
			mcost += cost[i];
			max = Math.max(cost[i], max);
		}

		return mcost-max;
	}
}