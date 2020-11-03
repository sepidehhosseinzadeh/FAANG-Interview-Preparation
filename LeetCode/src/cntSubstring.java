import java.util.*;

public class cntSubstring {
    public static void main(String[] args)
    {
        System.out.print(countSubstrings("abe", "bbc"));
    }

    public static int countSubstrings_v0(String ss, String t) {
        HashMap<String, Integer> subs = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            for (int j = i; j < t.length(); j++)
                subs.put(t.substring(i, j + 1),
                        subs.getOrDefault(t.substring(i, j + 1), 0) + 1);

        int cnt = 0;
        for (int i = 0; i < ss.length(); i++)
            for (int j = i; j < ss.length(); j++)
                for (int k = 0; k < j - i + 1; k++) {
                    StringBuilder s = new StringBuilder(ss.substring(i, j + 1));
                    int prev = s.charAt(k) - 'a';
                    for (int c = 0; c < 26; c++)
                        if (c != prev) {
                            s.setCharAt(k, (char) (c + 'a'));
                            if (subs.containsKey(s.toString()))
                                cnt += subs.get(s.toString());
                        }
                }

        return cnt;
    }

    // O(NMK)
    public static int countSubstrings_v1(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < t.length(); j++) {
                int diff = 0;
                for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) diff++;
                    if (diff == 1) res++;
                    if (diff > 1) break;
                }
            }
        return res;
    }

    // O(NM)
    public static int countSubstrings_v2(String s, String t) {
        var L = new int[s.length() + 1][t.length() + 1];
        var R = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

        for (int i = s.length(); i > 0; i--)
            for (int j = t.length(); j > 0; j--)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    R[i - 1][j - 1] = R[i][j] + 1;

        int res = 0;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++)
                if (s.charAt(i - 1) != t.charAt(j - 1))
                    res += (L[i - 1][j - 1] + 1) * (R[i][j] + 1);

        return res;

    }

    // O(NMK)
    public int countSubstrings_v3(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i)
            res += helper_v0(s, t, i, 0);
        for (int j = 1; j < t.length(); ++j)
            res += helper_v0(s, t, 0, j);
        return res;
    }
    public int helper_v0(String s, String t, int i, int j) {
        int res = 0;
        for (int n = s.length(), m = t.length(); i < n && j < m; ++i, ++j) {
            int diff = 0;
            for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {
                if (s.charAt(i + k) != t.charAt(j + k)) diff++;
                if (diff == 1) res++;
                if (diff > 1) break;
            }
        }
        return res;
    }

    // O(NM)
    public static int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i)
            res += helper(s, t, i, 0);
        for (int j = 1; j < t.length(); ++j)
            res += helper(s, t, 0, j);
        return res;
    }

    public static int helper(String s, String t, int i, int j) {
        int res = 0, pre = 0, cur = 0;
        for (int n = s.length(), m = t.length(); i < n && j < m; ++i, ++j) {
            cur++;
            if (s.charAt(i) != t.charAt(j)) {
                pre = cur;
                cur = 0;
            }
            res += pre;
        }
        return res;
    }
}
