import java.util.*;

public class patternMatch {
    int[][] memo;
    public boolean wildCard(String str, String pat) {
        while(str.contains("**"))
            str = str.replaceAll("**", "*");

        int np = pat.length(), ns = str.length();
        memo = new int[np+1][ns+1];
        for(int[] a : memo)
            Arrays.fill(a,-1);
        return match(0,0,pat,str,np,ns)==1;
    }

    int match(int pi,int si, String pat,String str, int np,int ns)
    {
        if(si==ns && pi==np)
            return 1;
        if(si < ns && pi == np)
            return 0;
        if(si == ns && pi < np && pat.charAt(pi) != '*')
            return 0;

        if(pi < np && si < ns)
            if(memo[pi][si] != -1)
                return memo[pi][si];

        if(pi < np && pat.charAt(pi) == '*')
            for(int len = 0; si+len <= ns; len++)
                if(match(pi+1, si+len, pat,str,np,ns)==1)
                    return memo[pi][si]=1;

        if(pi < np && pat.charAt(pi) == '?')
        {
            for(char c = 'a'; c <= 'z'; c++)
                if(match(pi+1, si+1, pat.substring(0,pi)+c+
                        (pi+1 < np?pat.substring(pi+1):""),str,np,ns)==1)
                    return memo[pi][si]=1;
            return memo[pi][si]=0;
        }
        if(pi < np && si < ns &&
                pat.charAt(pi)==str.charAt(si) &&
                match(pi+1,si+1,pat,str,np,ns)==1)
            return memo[pi][si]=1;
        if(pi < np && si < ns)
            return memo[pi][si]=0;
        return 0;
    }
    boolean matchDP(String pat1, String str1)
    {
        char[] pat = pat1.toCharArray();
        char[] str = str1.toCharArray();
        int np = pat.length, ns = str.length;
        boolean[][] match = new boolean[np + 1][ns + 1];

        // empty pattern can match with empty string
        match[0][0] = true;
        // Only '*' can match with empty string
        for (int i = 0; i < np; i++)
            if (pat[i] == '*')
                match[i + 1][0] = match[i][0];

        for (int i = 1; i <= np; i++)
            for (int j = 1; j <= ns; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pat[i - 1] == '*')
                    match[i][j] = match[i][j - 1] || match[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pat[i - 1] == '?' || pat[i - 1] == str[j - 1])
                    match[i][j] = match[i - 1][j - 1];

                    // If characters don't match
                else match[i][j] = false;
            }

        return match[np][ns];
    }

    public boolean matchDP_v1(String p, String s)
    {
        int n = s.length(), m = p.length();
        boolean[][] match = new boolean[n + 1][m + 1];

        match[n][m] = true;
        for (int i = m - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                match[n][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else
                    match[i][j] = false;
            }
        }
        return match[0][0];
    }
}
