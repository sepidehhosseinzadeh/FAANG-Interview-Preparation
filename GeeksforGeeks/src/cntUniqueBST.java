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
    static int countBSTDP(int n)
    {
        int[] dp = new int[n+1];

        dp[0] = 1; dp[1] = 1;

        for(int i = 2; i <= n; i++)
            for(int j = 1; j <= i; j++)
                dp[i] += dp[i-j]*dp[j-1];

        return dp[n];
    }
}




