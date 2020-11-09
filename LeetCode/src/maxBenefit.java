import java.util.*;
// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
public class maxBenefit {
    public static void main(String[] args)
    {
        System.out.print(maxProfit(new int[]{1000000000},1000000000));
    }

    static int mod = (int) 1e9 + 7;

    public static int maxProfit(int[] inventory, int orders) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int n : inventory) {
            pq.offer(n);
        }

        long profit = 0;
        while (!pq.isEmpty() && orders > 0) {
            int top = pq.poll();
            int top1 = 1;
            if (!pq.isEmpty()) top1 = pq.peek();

            int prev = Math.min(orders, top - top1 + 1);
            orders -= prev;
            profit = (profit + sum(top - prev+1, top)) % mod;

            pq.add(top - prev);
        }
        return (int) profit;
    }

    static long sum(int a, int b)
    {
        if (a > b) return 0;

        return (((b * (b+1))/2)%mod - ((a * (a+1))/2)%mod)%mod;
    }
}
