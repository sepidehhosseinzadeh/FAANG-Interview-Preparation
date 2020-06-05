import java.util.HashMap;

public class makeChangeCoins
{
    /*8.10.  Coins: Given an infinite number of quarters
    (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent),
    write code to calculate the number of ways of representing n cents.
     */
    public static void main(String[] args)
    {
        int[] coin = {25, 20, 5, 1};
        int n = 100;
//        System.out.println(compute(0, n, coin, new HashMap<>()));
//        System.out.println(compute(0, n, coin, new int[n+1][4]));

        int[][] dp = new int[n+1][4];
        for(int i = 0; i < 4; i++)
            dp[coin[i]][i]= 1;

        for(int i = 1; i <= n; i++)
            for(int k = 0; k+1 < 4; k++)
                for(int j = 0; j*coin[k] <= i; j++)
                    dp[i][k] += dp[i-j*coin[k]][k+1];

        System.out.println(dp[n][3]);

    }
    static int compute(int at, int n, int[] coin,
                       HashMap<Integer, Integer> map)
    {
        if(at == coin.length)
            return 0;

        if(coin[at] == 1)
            return 1;
        if(n <= 0)
            return 0;
        if(map.containsKey(n))
            return map.get(n);

        int ways = 0;
        for(int i = 0; i*coin[at] <= n; i++)
            ways += compute(at+1, n-i*coin[at], coin, map);

        map.put(n, ways);
        return ways;
    }
    static int compute(int at, int n, int[] coin,
                       int[][] map)
    {
        if(at == coin.length)
            return 0;

        if(coin[at] == 1)
            return 1;
        if(n <= 0)
            return 0;
        if(map[n][at] > 0)
            return map[n][at];

        int ways = 0;
        for(int i = 0; i*coin[at] <= n; i++)
            ways += compute(at+1, n-i*coin[at], coin, map);

        map[n][at] = ways;
        return ways;
    }
}
