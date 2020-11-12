import java.util.*;

public class buySellStockWithCoolDown {
    public static void main(String[] args)
    {
        System.out.print(maxProfit_v2(new int[]{1, 2, 3, 0, 2}));
    }

    // O(n^3)
    static int[] memo;
    public static int maxProfit(int[] prices) {
        memo = new int[prices.length];
        Arrays.fill(memo,-1);
        return maxProfit(0, prices);
    }
    static int maxProfit(int at, int[] prices)
    {
        if(at >= prices.length) return 0;
        if(memo[at] != -1) return memo[at];

        int maxProf = 0;
        for(int i = at; i < prices.length; i++) // buy
            for(int j = i+1; j < prices.length; j++) // sell
                if(prices[j] >= prices[i])
                {
                    maxProf = Math.max(maxProf, prices[j] - prices[i] + maxProfit(j+2, prices));
                }
        return memo[at] = maxProf;
    }

    static int maxProfit_v1(int[] prices)
    {
        int n = prices.length;
        if(n == 0) return 0;
        int[] maxProf = new int[n]; // maxProf[i]: max profit till i

        for(int i = 1; i < n; i++) { // sell
            maxProf[i] = maxProf[i-1]; // don't sell at i
            for(int j = 0; j < i; j++) // buy
                maxProf[i] = Math.max(maxProf[i], prices[i]-prices[j]+(j>1?maxProf[j-2]:0));
        }
        return maxProf[n-1];
    }

    static int maxProfit_v2(int[] prices)
    {
        int n = prices.length;
        if(n == 0) return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];

        for(int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], (i>1?sell[i - 2]:0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[n-1];
    }

}
