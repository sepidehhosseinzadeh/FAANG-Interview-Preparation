import java.util.*;

public class LongestPalinSubSeq_minDelToHavePali {
    public static void main(String[] args)
    {
    }
    static int lps(String seq)
    {
        int n = seq.length();
        int L[][] = new int[n][n];

        for (int i = 0; i < n; i++)
            L[i][i] = 1;

        for (int l=2; l<=n; l++)
            for (int i=0; i<n-l+1; i++) {
                int j = i + l - 1;
                if (seq.charAt(i) == seq.charAt(j) && l == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
            }

        return L[0][n-1];
    }
    static int minimumNumberOfDeletions(String str)
    {
        int n = str.length();
        // Find longest palindromic subsequence
        int len = lps(str);
        return (n - len);
    }
}
