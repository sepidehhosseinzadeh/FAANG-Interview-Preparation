import java.util.*;

public class minDelCharToaaabbb {
    // https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
    // str should be aaa...aabbb...bb.
    // So for loop on position of separation point,
    // and #b on left + #a on right is the #deletions needed
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] na = new int[n + 2];
        int[] nb = new int[n + 2];

        // #b till i from left
        nb[0] = 0;
        for (int i = 1; i <= n; i++)
            if (s.charAt(i - 1) == 'b') nb[i] = nb[i - 1] + 1;
            else nb[i] = nb[i - 1];

        // #a till i from right
        na[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i + 1) == 'a') na[i] = na[i + 1] + 1;
            else na[i] = na[i + 1];

        int res = s.length();
        for (int i = 0; i <= n; i++) // separate at i
            res = Math.min(res, nb[i] + na[i]);

        return res;
    }
}