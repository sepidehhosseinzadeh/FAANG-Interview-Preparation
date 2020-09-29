import java.util.*;

/*Given a binary matrix, find out the maximum size square sub-matrix with all 1s.*/

class maxSqureOf1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    mat[i][j] = sc.nextInt();

            System.out.println(bigSq(mat, n, m));
        }
    }
    static int bigSq(int[][] mat, int n, int m)
    {
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++)
            dp[i][0] = mat[i][0];

        for(int j = 0; j < m; j++)
            dp[0][j] = mat[0][j];


        int maxSq = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 0)
                    dp[i][j] = 0;
                else if(i>0 && j>0)
                    dp[i][j] = Math.min(dp[i-1][j-1],
                            Math.min(dp[i-1][j], dp[i][j-1]))+1;
                maxSq = Math.max(maxSq, dp[i][j]);
            }


        return maxSq;
    }
}
