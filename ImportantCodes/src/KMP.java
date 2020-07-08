import java.util.*;

public class KMP {
    public static void main(String[] args)
    {
    }
    static void kmp(String pat_, String txt_)
    {
        char[] pat = pat_.toCharArray();
        char[] txt = txt_.toCharArray();

        int i = 0, j = 0;
        int n = pat.length, m = txt.length;

        int[] lps = LPS(pat);

        while(j < m)
        {
            if(pat[i] == txt[j])
            {
                j++;
                i++;
            }
            if(i == n)
            {
                System.out.println("Match found at: "+(i-j));
                i = lps[i-1];
            }
            else if(pat[i] != txt[j])
            {
                if(i>0) i = lps[i-1];
                else j++;
            }
        }
    }
    // build Longest Prefix Suffix: where to start matching
    // in pattern, after a mismatch at i+1
    static int[] LPS(char[] pat)
    {
        int n = pat.length;
        int[] lps = new int[n];
        int i = 1, len = 0;
        lps[0] = 0;

        while (i < n)
        {
            if(pat[i] == pat[len])
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if(len == 0)
                {
                    lps[i] = len;
                    i++;
                }
                else
                    len = lps[len-1];
            }
        }
        return lps;
    }
}




