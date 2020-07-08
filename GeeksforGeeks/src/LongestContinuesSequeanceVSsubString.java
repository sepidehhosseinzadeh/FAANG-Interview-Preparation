import java.util.*;

public class LongestContinuesSequeanceVSsubString {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while(t-- > 0)
        {
            int n = sc.nextInt(), m = sc.nextInt();
            sc.nextLine();

            String s = sc.nextLine(), s1 = sc.nextLine();
            System.out.println(LCS(s.toCharArray(), s1.toCharArray()));
        }
    }
    static int LCS(char[] ch,  char[] ch1)
    {
        int n = ch.length, m = ch1.length;
        int[][] dp = new int[n][m];

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                if(ch[i] == ch1[j])
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    //// if substring -> dp[i][j] = 0;
                }

        return dp[n-1][m-1];

    }
}
