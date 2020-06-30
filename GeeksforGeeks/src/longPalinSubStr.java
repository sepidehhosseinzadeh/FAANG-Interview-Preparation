import java.util.*;

public class longPalinSubStr {
    int best_s;
    int best_n;
    public String longestPalindrome(String str) {
        best_s = 0; best_n = 0;
        if(str.length() < 2)
            return str;

        for(int s = 0; s < str.length(); s++)
        {
            expand(str, s, s);
            if(s+1 < str.length())
                expand(str, s, s+1);
        }
        return str.substring(best_s, best_s+best_n);

    }
    void expand(String s, int i, int j)
    {
        while(i >= 0 && j < s.length() &&
                s.charAt(i) == s.charAt(j))
        {
            i--; j++;
        }
        if(best_n < j-i-1)
        {
            best_n = j-i-1;
            best_s = i+1;
        }
    }
}

