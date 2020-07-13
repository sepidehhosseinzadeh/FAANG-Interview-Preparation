import java.util.*;

public class coinChangeVariation {
    /*
    We want to make change for N cents, and we have infinite supply of each of
    S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
     */
    public static void main(String[] args)
    {
    }
    int countWays_method0( int S[], int m, int n )
    {
        int[][] table = new int[n+1][m];
        for (int i = 0; i < m; i++)
            table[0][i] = 1;

        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < m; j++)
            {
                // Count of solutions including S[j]
                int inc = (i-S[j] >= 0) ? table[i - S[j]][j] : 0;
                // Count of solutions excluding S[j]
                int exc = (j >= 1) ? table[i][j - 1] : 0;
                table[i][j] = inc + exc;
            }

        return table[n][m - 1];
    }

    static long countWays_method1(int S[], int m, int n)
    {
        long[] table = new long[n+1];
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    // Find minimum of coins to make a given change V

    static int minCoins(int coins[], int m, int V)
    {
        if (V == 0) return 0;

        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V-coins[i]);

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }

        return res;
    }
    static int minNumbers_BFS(int x, int []arr, int n)
    {
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        HashSet<Integer> v = new HashSet<Integer>();

        int d = 0;

        while (q.size() > 0)
        {
            int s = q.size();
            while (s-- > 0)
            {
                int c = q.peek();

                if (c == 0)
                    return d;
                q.remove();
                if (v.contains(c) || c < 0)
                    continue;

                v.add(c);

                for (int i = 0; i < n; i++)
                    q.add(c - arr[i]);
            }
            d++;
        }

        return -1;
    }

}
