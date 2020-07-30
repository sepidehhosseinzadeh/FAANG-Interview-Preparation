import java.util.*;

public class cntPalinSubStr {
    public int countSubstrings(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        return countPalin_v2(s, n);
    }

    int countPalin_v2(char[] s, int n)
    {
        boolean[][] isPalin = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) // or using len!
            for (int j = i; j < n; j++) {
                isPalin[i][j] = (j - i + 1 <= 2 ||
                        isPalin[i + 1][j - 1]) && s[i] == s[j];
                if (isPalin[i][j]) count++;
            }
        return count;
    }

    int countPalin_v1(char[] s, int n) // has a bug
    {
        int[][] nPalin = new int[n + 1][n + 1];
        boolean[][] isPalin = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            nPalin[i][i] = 1;
            isPalin[i][i] = true;
        }
        for (int i = 0; i + 1 < n; i++)
            if (s[i] == s[i + 1]) {
                nPalin[i][i + 1] = 1;
                isPalin[i][i + 1] = true;
            }

        for (int l = 3; l <= n; l++)
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (isPalin[i + 1][j - 1] && s[i] == s[j]) {
                    nPalin[i][j] = 1 + nPalin[i + 1][j] + nPalin[i][j - 1] - nPalin[i + 1][j - 1];
                    isPalin[i][j] = true;
                }
                else
                    nPalin[i][j] = nPalin[i + 1][j] + nPalin[i][j - 1] - nPalin[i + 1][j - 1];
            }

        return nPalin[0][n - 1];
    }
}

