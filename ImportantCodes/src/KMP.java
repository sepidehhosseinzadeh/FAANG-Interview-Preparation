import java.util.*;

public class KMP {
    public static void main(String[] args) {
        kmp("abc","abcabcdfgabckl");
        /*
        Match found at: 0
        Match found at: 3
        Match found at: 9
         */
    }
    // o(n+m)
    static void kmp(String pat_, String txt_)
    {
        char[] pat = pat_.toCharArray();
        char[] txt = txt_.toCharArray();

        int i = 0, j = 0;
        int n = pat.length, m = txt.length;

        int[] p = kmp(pat);

        while(j < m)
        {
            if(pat[i] == txt[j])
            {
                j++;
                i++;
            }
            if(i == n)
            {
                System.out.println("Match found at: "+(j-i));
                i = p[i-1];
            }
            if(pat[i] != txt[j])
            {
                if(i>0) i = p[i-1];
                else j++;
            }
        }
    }
    // lps[i]: where to start matching
    // in pattern, after a mismatch at i+1
    // Longest suffix that also is a prefix
    static int[] kmp(char[] pat)
    {
        int n = pat.length;
        int[] p = new int[n];

        p[0] = 0;
        for(int i = 1; i < n; i++) {
            int len = p[i-1];
            while(len > 0 && pat[i] != pat[len]) len = p[len-1];
            p[i] = len + (pat[i] == pat[len]?1:0);
        }
        return p;
    }
}




