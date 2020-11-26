import java.util.*;

public class decodeWays {
    public int numDecodings_combination(String s) { // wrong!!!!
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int l = 1; l <= 2; l++)
            for (int i = 1; i <= n; i++) {
                if (i - l >= 0 && 0 < Integer.parseInt(s.substring(i - l, i)) &&
                        Integer.parseInt(s.substring(i - l, i)) < 27)
                    dp[i] += dp[i - l];
            }

        return dp[n];
    }

    public int numDecodings(String s) {  // stairs dp[i] = dp[i-1]+dp[i-2]
        int n = s.length();
        if(n == 0) return 0;

        int[] dp = new int[n+1]; // dp[len] dp[i] --> number of all possible decode ways of substring s(0 : i-1)
        dp[0] = 1; // dp[len=0]=1
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            if(0 < Integer.parseInt(s.substring(i-1,i)) &&
                    Integer.parseInt(s.substring(i-1,i)) < 10)
                dp[i] += dp[i-1];
            if(9 < Integer.parseInt(s.substring(i-2,i)) &&
                    Integer.parseInt(s.substring(i-2,i)) < 27)
                dp[i] += dp[i-2];
        }

        return dp[n];
    }
    /* space opt
    int numDecodings(string s) {
        int a = 0, b = 1, c = 0;
        s = "0" + s;
        for (int i = 1; i < s.size(); i++) {
            if (s[i] != '0') c += b;
            if ("09" < s.substr(i - 1, 2) && s.substr(i - 1, 2) < "27") c += a;
            a = b;
            b = c;
            c = 0;
        }
        return s.empty() ? 0 : b;
    }*/
}