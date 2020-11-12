import java.util.*;

public class stockBuySellAtMost2 {
    public static void main(String[] args)
    {
    }
    // O(n^2)
    public int maxProfit(int[] prices) {
        int maxProf = 0, n = prices.length;
        for(int i = 0; i+1 < n; i++)
            maxProf = Math.max(maxProf, maxProfit_1(prices, 0, i) +
                                    maxProfit_1(prices, i, n-1));
        return maxProf;
    }
    public int maxProfit_1(int[] prices, int l, int r) {
        int maxProf = 0, minPrice = Integer.MAX_VALUE;
        for(int i = l; i <= r;i++)
        {
            minPrice = Math.min(minPrice, prices[i]);
            maxProf = Math.max(maxProf, prices[i]-minPrice);
        }
        return maxProf;
    }

    // 
}
