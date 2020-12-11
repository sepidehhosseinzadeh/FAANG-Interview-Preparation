import java.util.*;

// https://leetcode.com/problems/minimum-window-substring/
// Given a string S and a string T,
// find the minimum window in S which will contain all the characters in T.

public class minWinSubStr {
    public String minWindow_(String ss, String tt) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        var t = new HashMap<Character, Integer>();
        var win =  new HashMap<Character, Integer>();

        for(char c : tt.toCharArray()) t.put(c, t.getOrDefault(c,0)+1);

        int i = 0, j = 0, len = 0;
        int minLen = Integer.MAX_VALUE, I = -1, J = -1;

        while(i < n && j < n) {
            win.put(s[j], win.getOrDefault(s[j],0)+1);
            if(t.containsKey(s[j]) && win.get(s[j]) <= t.get(s[j])) len++;

            while(i<n && win.containsKey(s[i]) &&
                    (!t.containsKey(s[i]) || win.get(s[i]) > t.get(s[i]))) {
                win.put(s[i], win.get(s[i])-1);

                if(t.containsKey(s[i]) && win.get(s[i]) < t.get(s[i])) len--;

                if(win.get(s[i]) == 0) win.remove(s[i]);
                i++;
            }

            if(len == tt.length() && j-i+1 < minLen) {
                minLen = j-i+1;
                I = i; J = j;
            }
            j++;
        }
        if(minLen == Integer.MAX_VALUE) return "";

        String res = "";
        for(int k = I; k <= J; res += s[k], k++);

        return res;
    }
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