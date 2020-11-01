import java.util.*;

public class cntSubstring {
    public static void main(String[] args)
    {
        System.out.print(countSubstrings("abe","bbc"));
    }

    static int countSubstrings(String ss, String t) {

        HashMap<String, Integer> subs = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            for (int j = i; j < t.length(); j++)
                subs.put(t.substring(i, j + 1),
                        subs.getOrDefault(t.substring(i, j + 1),0)+1);

        int cnt = 0;
        for (int i = 0; i < ss.length(); i++)
            for (int j = i; j < ss.length(); j++)
                for (int k = 0; k < j - i + 1; k++) {
                    StringBuilder s = new StringBuilder(ss.substring(i, j + 1));
                    int prev = s.charAt(k)-'a';
                    for (int c = 0; c < 26; c++)
                        if (c != prev)
                        {
                            s.setCharAt(k, (char) (c + 'a'));
                            if (subs.containsKey(s.toString()))
                                cnt += subs.get(s.toString());
                        }
                }

        return cnt;
    }
    static int countSubstrings_v1(String ss, String tt)
    {
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        int ans = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < t.length; j++) {
                int cnt = 0;
                for (int k = 0; i + k < s.length && j + k < t.length; k++) {
                    if (s[i + k] != t[j + k]) cnt++;
                    if (cnt == 1) ans++;
                }
            }
        }
        return ans;
    }
}

