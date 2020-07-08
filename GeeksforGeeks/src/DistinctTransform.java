import java.util.*;
import java.lang.*;

/*
Given two sequences A, B, find out number of unique ways in sequence A,
to form a subsequence that is identical to the sequence B.

Example :
A = "abcccdf"  B = "abccdf"

Return 3. And the formations as follows:

A1= "ab.ccdf"
A2= "abc.cdf"
A3="abcc.df"

"." is where character is removed.
 */
class DistinctTransform {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            String s = sc.nextLine(), s1 = sc.nextLine();
            System.out.println(numTrans(s, s1));
        }
    }
    static int numTrans(String a, String b)
    {
        int n = a.length(), m = b.length();

        // deleteing all chars
        if (m == 0)
            return 1;

        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = i; j < n; j++)
            {
                if (i == 0)
                {
                    if (j == 0)
                        dp[i][j] = (a.charAt(j) == b.charAt(i)) ? 1 : 0;

                    else if (a.charAt(j) == b.charAt(i))
                        dp[i][j] = dp[i][j - 1] + 1;
                    else
                        dp[i][j] = dp[i][j - 1];
                }
                else if (a.charAt(j) == b.charAt(i))
                    dp[i][j] = dp[i][j - 1]
                            + dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        return dp[m - 1][n - 1];
    }
}
