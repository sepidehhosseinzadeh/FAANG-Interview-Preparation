import java.util.*;

public class permutSubStr {
    public static void main(String[] args)
    {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("acb", "acab"));
    }
    public static boolean checkInclusion(String S1, String S2) {
        char[] s1 = S1.toCharArray();
        char[] s2 = S2.toCharArray();
        int n1 = s1.length, n2 = s2.length;
        int[] map = new int[26];
        int fit = 0;
        for(int i = 0; i < n1; i++)
            map[s1[i]-'a']++;

        for(int i = 0; i < n2; i++)
        {
            if(i>=n1) map[s2[i-n1]-'a']++;
            map[s2[i]-'a']--;
            if(match(map)) return true;
        }
        return false;
    }
    static boolean match(int[] map) {
        int fit = 0;
        for(int i : map) if(i == 0) fit++;
        return fit == 26;
    }
}
