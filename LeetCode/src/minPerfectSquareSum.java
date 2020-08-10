import java.util.*;

public class minPerfectSquareSum {
    // Perfect Squares: Given a positive integer n, find the least number of perfect square numbers
    // (for example, 1, 4, 9, 16, ...) which sum to n.

    public int numSquares(int n) {
        ArrayList<Integer> ps = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            ps.add(0, i * i);

        Queue<Integer> q = new LinkedList<>();
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        q.add(n);
        cost[n] = 0;

        while (!q.isEmpty()) {
            int at = q.remove();

            for (int p : ps)
                if (at >= p && cost[at - p] > cost[at] + 1) {
                    q.add(at - p);
                    cost[at - p] = cost[at] + 1;
                }
        }
        return cost[0];
    }
}


