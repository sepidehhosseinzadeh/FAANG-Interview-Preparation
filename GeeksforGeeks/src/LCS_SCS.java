import java.util.*;

public class LCS_SCS {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            String[] str = sc.nextLine().split("[ ]");
            char[] s1 = str[0].toCharArray();
            char[] s2 = str[1].toCharArray();

            System.out.println(SCS(s1,s2));
            System.out.println(LCS(s1,s2));
        }
    }
    // Shortest Common Supersequence
    static int SCS(char[] s1, char[] s2)
    {
        int n = s1.length, m = s2.length;
        int[][] scs = new int[n+1][m+1];

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                if(i == 0)
                    scs[0][j] = j;
                else if(j == 0)
                    scs[i][0] = i;
                else if(s1[i-1] == s2[j-1])
                    scs[i][j] = scs[i-1][j-1]+1;
                else
                    scs[i][j] = Math.min(scs[i-1][j], scs[i][j-1])+1;

        return scs[n][m];
    }
    // Longest Common Subsequence
    static int LCS( char[] s1, char[] s2)
    {
        int n = s1.length, m = s2.length;

        int lcs[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (s1[i-1] == s2[j-1])
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        return lcs[m][n];
    }
}
