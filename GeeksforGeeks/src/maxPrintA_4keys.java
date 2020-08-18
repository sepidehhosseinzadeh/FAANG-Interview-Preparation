import java.util.*;

public class maxPrintA_4keys {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            System.out.println(maxPA(n, dp));
        }
    }
    static int maxPA(int n, int[] dp)
    {
        if(n <= 6)  return n;
        if(dp[n] >= 0) return dp[n];

        int max = 0, j = 2;
        for(int i = n-3; i >= 1; i--, j++)
            max = Math.max(max, maxPA(i,dp)*j);

        return dp[n] = max;
    }
}