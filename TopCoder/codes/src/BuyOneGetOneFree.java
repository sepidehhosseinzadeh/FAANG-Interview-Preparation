import java.util.*;
public class BuyOneGetOneFree
{
    public int buy(int[] prices)
    {
        int res = 0, n = prices.length;
        Arrays.sort(prices);
        for (int i = n-1; i-1 >= 0; i--) {
            int price = prices[i];
            i--;
            res += price;
        }
        if(n%2 != 0) res += prices[0];
        return res;
    }

}


// Powered by FileEdit
// Powered by CodeProcessor
