import java.util.*;

public class stockBuySellAtMost2 {
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

    // O(n)
    /*
    Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
    Then the tricky part comes, how to handle the twoBuy? You have bought and sold a stock and made $100 dollar profit.
    When you want to purchase a stock which costs you $300 dollars, how would you think this? You must think, um,
    I have made $100 profit, so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
    There we go, you got the idea how we calculate twoBuy!! We just minimize the cost again!!
    The twoBuyTwoSell is just making as much profit as possible.
     */
    public int maxProfit_v1(int[] prices) {
        int inf = Integer.MAX_VALUE;
        int buy1 = inf, buy2 = inf, sell1=0, sell2 = 0;

        for(int p : prices)
        {
            buy1 = Math.min(buy1, p);
            sell1 = Math.max(sell1, p-buy1);

            buy2 = Math.min(buy2, -sell1+p);
            sell2 = Math.max(sell2, p-buy2);
        }
        return sell2;
    }

    // O(n) States/DP
    /*
    To reach s1, we either stay in s1 or we buy stock for the first time.
    To reach s2, we either stay in s2 or we sell from s1 and come to s2
    Similarly for s3 and s4.
    Technically, this is a DP: s2[i] = max(s2[i-1], s1[i-1]+prices[i])
     */
    public int maxProfit_v2(int[] prices)
    {
        int inf = Integer.MAX_VALUE;
        int s1 = -prices[0], s2 = -inf, s3 = -inf, s4 = 0;

        for (int i = 1; i < prices.length; ++i) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return s4;
    }
}
