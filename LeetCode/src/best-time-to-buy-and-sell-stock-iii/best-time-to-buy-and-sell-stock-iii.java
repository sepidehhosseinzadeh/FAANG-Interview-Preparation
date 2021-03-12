class Solution {
    public int maxProfit_v0(int[] prices) {
        int maxProf = 0, n = prices.length;
        for(int i = 0; i+1 < n; i++)
            maxProf = Math.max(maxProf, maxProfit1(prices, 0, i) + 
                                        maxProfit1(prices, i, n-1));
        return maxProf;
    }
    public int maxProfit1(int[] prices, int l, int r) {
        int maxProf = 0, minPrice = Integer.MAX_VALUE;
        for(int i = l; i <= r;i++)
        {
            minPrice = Math.min(minPrice, prices[i]);
            maxProf = Math.max(maxProf, prices[i]-minPrice);
        }
        return maxProf;
    }
    
    // O(n) 
    public int maxProfit(int[] prices) {
        int inf = Integer.MAX_VALUE;
        int buy1 = inf, buy2 = inf, prof1=0, prof2 = 0;
        
        for(int p : prices)
        {
            buy1 = Math.min(buy1, p);
            prof1 = Math.max(prof1, p-buy1);
            buy2 = Math.min(buy2, -prof1+p);
            prof2 = Math.max(prof2, p-buy2);
        }
        return prof2;
    }
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