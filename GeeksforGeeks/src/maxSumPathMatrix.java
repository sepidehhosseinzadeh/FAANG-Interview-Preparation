import java.util.*;
import java.lang.*;

class maxSumPathMatrix {
    static int maxSum;
    static int[] dx = new int[]{1,1,1};
    static int[] dy = new int[]{0,-1,1};
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            maxSum = 0;
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    mat[i][j] = sc.nextInt();

            int[][] memo = new int[n+1][n+1];
            for(int[] a : memo)
                Arrays.fill(a, -1);

            boolean[][] vis = new boolean[n][n];
//            for(int j = 0; j < n; j++)
//                maxSumPath(0,j,mat,mat[0][j],vis,memo,n);

            for(int j = 0; j < n; j++)
                maxSumPathDP(mat,n);

            System.out.println(maxSum);
        }
    }
    static void maxSumPath(int atx, int aty, int[][] mat,
                           int curSum, boolean[][] vis,int n)
    {
        if(atx == n-1)
        {
            maxSum = Math.max(maxSum, curSum);
            vis[atx][aty] = false;
            return;
        }
        vis[atx][aty] = true;
        for(int i = 0; i < 3; i++)
        {
            int x = atx+dx[i], y = aty+dy[i];
            if(x >= 0 && y >= 0 && x < n && y < n)
                if(!vis[x][y])
                    maxSumPath(x,y,mat,curSum+mat[x][y],vis,n);
        }
        vis[atx][aty] = false;
    }
    static void maxSumPathDP(int[][] mat,int n)
    {
        int[][] dp = new int[n][n];
        dp[0][0] = mat[0][0];
        for(int j = 1; j < n; j++)
            dp[0][j] = mat[0][j];

        for(int i = 1; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = mat[i][j] + Math.max(j==n-1?0:dp[i-1][j+1],
                        Math.max(dp[i-1][j], j<=0?0:dp[i-1][j-1]));

        for(int j = 0; j < n; j++)
            maxSum = Math.max(dp[n-1][j], maxSum);
    }
}







