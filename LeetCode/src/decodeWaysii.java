import java.util.*;

public class decodeWaysii {
    /*
    one = {'1': 1, '2': 1, '3': 1, '4': 1, '5': 1, '6': 1, '7': 1, '8': 1, '9': 1, '*': 9}
    two = {'10': 1, '11': 1, '12': 1, '13': 1, '14': 1, '15': 1, '16': 1, '17': 1, '18': 1, '19': 1, '20': 1, '21': 1,
           '22': 1, '23': 1, '24': 1, '25': 1, '26': 1, '*0': 2, '*1': 2, '*2': 2, '*3': 2, '*4': 2, '*5': 2, '*6': 2,
           '*7': 1, '*8': 1, '*9': 1, '1*': 9, '2*': 6, '**': 15}

    def numDecodings(self, s):
        dp = 1, one.get(s[:1], 0)

        for i in xrange(1, len(s)):
            dp = dp[1], (one.get(s[i], 0) * dp[1] + two.get(s[i-1: i+1], 0) * dp[0]) % 1000000007

        return dp[-1]
     */
    static Map<Character, Integer> one = new HashMap<>();
    static Map<String, Integer> two = new HashMap<>();

    static {
        for (char ci = '1'; ci <= '9'; ci++)
            one.put(ci, 1);
        one.put('*', 9);
        one.put('0', 0);
        for (int i = 10; i <= 26; i++)
            two.put("" + i, 1);
        for (int i = 0; i <= 9; i++)
            two.put("*" + i, i <= 6 ? 2 : 1);
        two.put("**", 15);
        two.put("1*", 9);
        two.put("2*", 6);
    }

    public int numDecodings(String s) {
        long[] dp = new long[3];
        dp[0] = 1;
        dp[1] = one.getOrDefault(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            dp[(i + 1) % 3] = dp[i % 3] * one.get(s.charAt(i))
                    + dp[(i - 1) % 3] * two.getOrDefault(s.substring(i - 1, i + 1), 0);
            dp[(i + 1) % 3] %= 1000000007;
        }
        return (int) dp[s.length() % 3];
    }
}