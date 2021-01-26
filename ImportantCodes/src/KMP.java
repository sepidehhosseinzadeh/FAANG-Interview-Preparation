import java.util.*;

public class KMP {
    public static void main(String[] args) {
        System.out.println(matchIndices(("abcabcdfgabckl").toCharArray(),
                ("abc").toCharArray()));
        /*
        Match found at: 0
        Match found at: 3
        Match found at: 9
         */
    }
    // o(n+m)
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
    static boolean match(char[] txt, char[] pat) {
        int[] p = kmp(pat);
        for(int i = 0, l = 0; i < txt.length && l < pat.length; i++) {
            while(l > 0 && txt[i] != pat[l]) l = p[l-1];
            l = l + (txt[i]==pat[l] ? 1 : 0);

            if(l == pat.length) return true;
        }
        return false;
    }

    static ArrayList<Integer> matchIndices(char[] txt, char[] pat) {
        var indices = new ArrayList<Integer>();
        int[] p = kmp(pat);
        for(int i = 0, l = 0; i < txt.length && l < pat.length; i++) {
            while(l > 0 && txt[i] != pat[l]) l = p[l-1];
            l = l + (txt[i]==pat[l] ? 1 : 0);
            if(l == pat.length) {
                indices.add(i-l+1); // Match found at: (i-l)
                l = p[l-1];
            }
        }
        return indices;
    }
}




