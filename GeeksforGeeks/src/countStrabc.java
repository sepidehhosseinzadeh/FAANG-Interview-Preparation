import java.util.*;

public class countStrabc {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            //System.out.println(ways(n));

            int[][][] dp = new int[n+1][1+1][2+1];
            for(int[][] a: dp)
                for(int[] b : a)
                    Arrays.fill(b,-1);

            System.out.println(waysDP(n, 1, 2, dp));
        }
    }
    static long ways(int n)
    {
        long facn = fac(n);
        long cnt = 0;
        for(int b = 0; b <= 1; b++)
            for(int c = 0; c <= 2; c++) {
                int a = Math.max(0, n-c-b);
                if(a + b + c == n)
                    cnt += facn/fac(a)*fac(b)*fac(c);
            }
        return cnt;
    }
    static long fac(int n)
    {
        int res = 1;
        for(int i = 1; i <= n; i++)
            res *= i;
        return res;
    }

    static int waysDP(int n, int a, int b, int[][][] memo)
    {
        if(a < 0 || b < 0) return 0;
        if(n == 0) return 1;
        if(a == 0 && b == 0)    return 1;
        if(memo[n][a][b] != -1) return memo[n][a][b];
        int cnt = 0;
        cnt += waysDP(n-1, a, b, memo);
        cnt += waysDP(n-1, a-1, b, memo);
        cnt += waysDP(n-1, a, b-1, memo);

        return memo[n][a][b] = cnt;

    }

}