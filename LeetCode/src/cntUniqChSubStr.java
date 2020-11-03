import java.util.*;

// https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class cntUniqChSubStr {
    public static void main(String[] args)
    {
        System.out.print(uniqueLetterString("ABA"));
    }

    static int MOD = (int) (1e9 + 7);

    public static int uniqueLetterString(String s) {
        int res = 0;
        var idx = new int[26][2]; // char, last two appearance
        for (int i = 0; i < 26; Arrays.fill(idx[i], -1), i++) ;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            res = (res + (i - idx[c][1]) * (idx[c][1] - idx[c][0]) % MOD) % MOD;

            idx[c][0] = idx[c][1];
            idx[c][1] = i;
        }
        // WRONG! becuz for repeated char, it counts again
        // for(int i = 0; i < s.length(); i++)
        // {
        //     int c = s.charAt(i)-'A';
        //     res = (res+(s.length()-idx[c][1])*(idx[c][1]-idx[c][0])%MOD)%MOD;
        // }
        for (int i = 0; i < 26; i++)
            res = (res + (s.length() - idx[i][1]) * (idx[i][1] - idx[i][0]) % MOD) % MOD;

        return res;
    }
}
