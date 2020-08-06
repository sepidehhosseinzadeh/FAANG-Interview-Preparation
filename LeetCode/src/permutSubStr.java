import java.util.*;

public class permutSubStr {
    public static void main(String[] args)
    {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("acb", "acab"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1m = new HashMap<>();
        HashMap<Character, Integer> cur = new HashMap<>();

        for(int i = 0; i < s1.length(); i++)
            s1m.put(s1.charAt(i), s1m.getOrDefault(s1.charAt(i),0)+1);

        int i = 0, j = 0;
        while(j < s2.length())
        {
            char c = s2.charAt(j);

            if(s1m.containsKey(c))
            {
                if(!cur.containsKey(c) || s1m.get(c) > cur.get(c))
                    cur.put(c, cur.getOrDefault(c,0)+1);
                else
                {
                    while(i<=j && cur.containsKey(s2.charAt(i)) &&
                            (s1m.get(s2.charAt(i)) < cur.get(s2.charAt(i)) ||
                                    s2.charAt(i)==c))
                    {
                        cur.put(s2.charAt(i), cur.get(s2.charAt(i))-1);
                        if(cur.get(s2.charAt(i)) == 0)
                            cur.remove(s2.charAt(i));
                        i++;
                    }
                    cur.put(c, cur.getOrDefault(c,0)+1);
                }
            }
            else
            {
                if(j-i==s1.length() && checkEq(cur, s1m))
                    return true;
                cur.clear();
                i = j+1;
            }
            if(j-i+1==s1.length() && checkEq(cur, s1m))
                return true;
            j++;
        }
        return false;
    }
    static boolean checkEq(HashMap<Character, Integer> a, HashMap<Character, Integer> b)
    {
        if(a.size() != b.size()) return false;
        for(char c : a.keySet())
            if(!b.containsKey(c) || a.get(c) != b.get(c))
                return false;

        return true;
    }
}
