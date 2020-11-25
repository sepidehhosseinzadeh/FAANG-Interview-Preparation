import java.util.*;

public class SCS_LIS {
    public String shortestCommonSupersequence_v0(String t, String s) {
        int n = t.length(), m = s.length();
        int[][] scs = new int[n+1][m+1];

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                if(i == 0) scs[0][j] = j;
                else if(j == 0) scs[i][0] = i;
                else if(t.charAt(i-1) == s.charAt(j-1))
                    scs[i][j] = scs[i-1][j-1]+1;
                else
                    scs[i][j] = Math.min(scs[i-1][j],
                            scs[i][j-1])+1;

        String res = "";
        int i = n, j = m;
        while(i > 0 && j > 0)
        {
            if(t.charAt(i-1) == s.charAt(j-1)) {
                res = t.charAt(i-1)+res; i--; j--;
            } else {
                if(scs[i-1][j] > scs[i][j-1])
                {res = s.charAt(j-1)+res; j--;}
                else
                {res = t.charAt(i-1)+res; i--;}
            }
        }
        while(i > 0) {res = t.charAt(i-1)+res; i--;}
        while(j > 0) {res = s.charAt(j-1)+res; j--;}

        return res;
    }

    // with help of lcs
    public String shortestCommonSupersequence(String t, String s) {
        int n = t.length(), m = s.length();
        int[][] lcs = new int[n+1][m+1];

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                if(t.charAt(i-1) == s.charAt(j-1))
                    lcs[i][j] = lcs[i-1][j-1]+1;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j],
                            lcs[i][j-1]);

        String res = "";
        int i = n, j = m;
        while(i > 0 && j > 0)
        {
            if(t.charAt(i-1) == s.charAt(j-1)) {
                res = t.charAt(i-1)+res; i--; j--;
            } else {
                if(lcs[i-1][j] < lcs[i][j-1])
                {res = s.charAt(j-1)+res; j--;}
                else
                {res = t.charAt(i-1)+res; i--;}
            }
        }
        while(i > 0) {res = t.charAt(i-1)+res; i--;}
        while(j > 0) {res = s.charAt(j-1)+res; j--;}

        return res;

    }

    // space optimized
    String shortestCommonSupersequence_v1(String a, String b) {
        char[] A = a.toCharArray(), B = b.toCharArray();
        int i = 0, j = 0;
        String res = "";
        String lcs = lcs(A, B);
        for (char c : lcs.toCharArray()) { // all the charsin lcs should be in res ONCE
            while (A[i] != c) res += A[i++];
            while (B[j] != c) res += B[j++];
            res += c; i++; j++;
        }
        return res + a.substring(i) + b.substring(j);
    }

    String lcs(char[] A, char[] B) {
        int n = A.length, m = B.length;
        String[][] dp = new String[n+1][m+1];
        for(String[] a: dp) Arrays.fill(a,"");

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (A[i] == B[j])
                    dp[i + 1][j + 1] = dp[i][j] + A[i];
                else
                    dp[i + 1][j + 1] = dp[i + 1][j].length() > dp[i][j + 1].length() ?
                            dp[i + 1][j] : dp[i][j + 1];
        return dp[n][m];
    }
}
