import java.util.*;

public class buySellStockWithCoolDown {
    public static void main(String[] args)
    {
        System.out.print(maxProfit(new int[]{1,2,3,0,2}));
    }
    public static int maxProfit(int[] prices) {
        return maxProfit(0, prices);
    }
    // O(n^3) 
    static int maxProfit(int at, int[] prices)
    {
        if(at >= prices.length) return 0;

        int maxProf = 0;
        for(int i = at; i < prices.length; i++) // buy
            for(int j = i+1; j < prices.length; j++) // sell
                if(prices[j] >= prices[i])
                {
                    maxProf = Math.max(maxProf, prices[j] - prices[i] + maxProfit(j+2, prices));
                }
        return maxProf;
    }


}
