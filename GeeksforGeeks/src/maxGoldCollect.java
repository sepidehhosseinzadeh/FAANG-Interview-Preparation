import java.util.*;

public class maxGoldCollect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    mat[i][j] = sc.nextInt();

            System.out.println(maxCoin(mat, n, m));
        }
    }

    static int maxCoin(int[][] mat, int n, int m)
    {
        int[][] maxC = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++)  // iterate col first! cuz u're moving col-wise
            for (int i = 0; i <= n; i++) {
                int maxGold = 0;
                if (i > 0)
                    maxGold = maxC[i - 1][j - 1] + mat[i - 1][j - 1];
                if (i < n)
                    maxGold = Math.max(maxGold, maxC[i][j - 1] + mat[i][j - 1]);
                if (i + 1 < n)
                    maxGold = Math.max(maxGold, maxC[i + 1][j - 1] + mat[i + 1][j - 1]);
                maxC[i][j] = maxGold;
            }

        int max = 0;
        for (int i = 0; i <= n; i++)
            max = Math.max(max, maxC[i][m]);

        return max;
    }
}