import java.util.*;

public class knapsack {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int W = sc.nextInt();

            int[] v = new int[n];
            for(int i = 0; i < n; i++)
                v[i] = sc.nextInt();
            int[] w = new int[n];
            for(int i = 0; i < n; i++)
                w[i] = sc.nextInt();

            int[][] memo = new int[n][W+1];
            for(int[] a : memo) Arrays.fill(a, -1);

            System.out.println(maxVal(0, W, w, v, memo));
            //System.out.println(maxValDP(W, w, v));
        }
    }
    static int maxVal(int i, int W, int[] w, int[] v, int[][] memo)
    {
        if(i == v.length)
            return 0;

        if(memo[i][W] != -1)
            return memo[i][W];

        int with_i = 0;
        if(w[i] < W)
            with_i = v[i]+maxVal(i+1, W-w[i], w, v, memo);
        int without_i = maxVal(i+1, W, w, v, memo);

        return memo[i][W] = Math.max(with_i, without_i);

    }

    static int maxValDP(int W, int[] w, int[] v)
    {
        int n = v.length;
        int[][] maxVal = new int[n+1][W+1];

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= W; j++)
            {
                if(i == 0 || j == 0) continue;
                maxVal[i][j] = Math.max(j < w[i-1] ? 0 :
                                (maxVal[i-1][j-w[i-1]]+v[i-1]),
                        maxVal[i-1][j]);
            }

        return maxVal[n][W];
    }
}
