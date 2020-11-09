import java.util.*;
// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
public class maxBenefit {
    public static void main(String[] args)
    {
        System.out.print(maxProfit(new int[]{1000000000},1000000000));
    }

    static int mod = (int) 1e9 + 7;

    // Time Limit Exception
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
            profit = (profit + sum(top - prev, top)) % mod;

            pq.add(top - prev);
        }
        return (int) profit;
    }

    static long sum(int a, int b)
    {
        if (a > b) return 0;
        return ((long)(b-a)*(b+a+1)/2)%mod;
    }

    // optimal approach
    // https://leetcode.com/problems/sell-diminishing-valued-colored-balls/discuss/927560/C%2B%2B-Binary-Answer
    public int maxProfit_v1(int[] inventory, int orders) {
        int lo=0, hi=1000000000, mid=lo+(hi-lo)/2;
        while(lo<hi) {
            if(check(inventory, mid, orders)) lo=mid+1;
            else hi=mid;
            mid=lo+(hi-lo)/2;
        }
        long res=0;
        for(int i=0;i<inventory.length;i++) {
            if(inventory[i]<=mid) continue;
            res+=((long)inventory[i]+(long)mid+1)*((long)(inventory[i]-mid))/2;
            orders-=(inventory[i]-mid);
        }
        res+=(long)orders*(long)mid;
        return (int)(res%1000000007);
    }

    boolean check(int[] inv, int n, int orders) {
        for(int i=0;i<inv.length&&orders>0;i++) orders-=Math.max(0, inv[i]-n);
        return orders<=0;
    }
}
