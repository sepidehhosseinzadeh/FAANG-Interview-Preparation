import java.util.*;

public class minCoinChange {
    public int coinChange(int[] coins, int m) {
        int n = coins.length;
        var ways = new int[m+1];
        Arrays.fill(ways, Integer.MAX_VALUE/2);

        ways[0] = 0;

        for(int i = 1; i <= m; i++)
            for(int j = 0; j < n; j++)
                if(i >= coins[j])
                    ways[i] = Math.min(ways[i],
                            ways[i-coins[j]]+1);

        return ways[m] >= Integer.MAX_VALUE/2 ? -1 : ways[m];

    }
}
