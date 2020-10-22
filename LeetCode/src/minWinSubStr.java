import java.util.*;

// https://leetcode.com/problems/minimum-window-substring/
// Given a string S and a string T,
// find the minimum window in S which will contain all the characters in T.

public class minWinSubStr {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tm = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray())
            tm.put(c, tm.getOrDefault(c, 0) + 1);

        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0, j = 0; j < s.length(); j++) {
            window.put(s.charAt(j),
                    window.getOrDefault(s.charAt(j), 0) + 1);

            if (tm.containsKey(s.charAt(j)) &&
                    window.get(s.charAt(j)) <= tm.get(s.charAt(j)))
                required--;

            while (i <= j && required == 0) {
                if (minLen > j - i) {
                    minLen = j - i;
                    res = s.substring(i, j + 1);
                }

                window.put(s.charAt(i), window.get(s.charAt(i)) - 1);
                if (tm.containsKey(s.charAt(i)) &&
                        window.get(s.charAt(i)) < tm.get(s.charAt(i)))
                    required++;
                i++;
            }

        }

        return res;
    }
}