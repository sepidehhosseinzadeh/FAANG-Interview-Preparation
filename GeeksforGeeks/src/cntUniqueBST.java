import java.util.*;

public class cntUniqueBST {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[][] memo = new int[n+1][n+1];
            for(int[] a : memo)
                Arrays.fill(a, -1);

            System.out.println(countBST(1, n, memo));
        }
    }
    static int countBST(int lb, int ub, int[][] memo)
    {
        if(lb > ub) return 1;
        if(lb == ub)    return 1;
        if(memo[lb][ub] != -1)  return memo[lb][ub];

        int cnt = 0;
        for(int i = lb; i <= ub; i++)
            cnt += countBST(lb, i-1, memo)*countBST(i+1, ub, memo);

        return memo[lb][ub] = cnt;
    }
    static int countBST_v1(int n, int[] memo)
    {
        if(memo[n] != -1) return memo[n];

        int cnt = 0;
        for(int root = 1; root <= n; root++)
            cnt += countBST_v1(root-1, memo) * countBST_v1(n-root, memo);

        return memo[n] = cnt;
    }
    static int countBSTDP(int N)
    {
        int[] dp = new int[N+1];

        dp[0] = 1;

        for(int n = 1; n <= N; n++)
            for(int root = 1; root <= n; root++)
                dp[n] += dp[root-1] * dp[n-root]; //left * right

        return dp[N];
    }
}




