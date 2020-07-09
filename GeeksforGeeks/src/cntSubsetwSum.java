import java.util.*;
import java.lang.*;

/*
Count all subsets of given array with sum equal to given sum.
 */
class cntSubsetwSum {
    static long mod = (long)1e9+7;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int s = sc.nextInt();

            long[][] memo = new long[n][s+1];
            for(long[] a : memo)
                Arrays.fill(a, -1);
            System.out.println(countSum(0, arr, n, s, memo));
        }
    }
    static long countSum(int at, int[] arr, int n, int sum, long[][] memo)
    {
        if(sum == 0)
            return 1;
        if(at == n && sum != 0)
            return 0;
        if(memo[at][sum] != -1)
            return memo[at][sum];

        long cnt = 0;
        if(arr[at] <= sum)
            cnt += countSum(at+1, arr, n, sum-arr[at], memo)%mod;
        cnt += countSum(at+1, arr, n, sum, memo)%mod;

        return memo[at][sum] = cnt%mod;
    }
}
