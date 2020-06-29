/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/*smallest window length that contains all the
characters of the given string at least one time.*/

class smallWinHaveAll {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            String s = sc.nextLine();
            System.out.println(minLen(s.toCharArray()));
        }
    }
    static int minLen(char[] ch)
    {
        int n = ch.length;
        int minLen = ch.length;
        HashMap<Character, Integer> cnt = new HashMap<>();

        HashSet<Character> set = new HashSet<>();
        for(char c : ch) set.add(c);

        int i = 0, j = 0;
        while(i < n && j < n)
        {
            cnt.put(ch[j], cnt.getOrDefault(ch[j], 0)+1);
            j++;
            while(i < j && cnt.get(ch[i]) > 1)
            {
                cnt.put(ch[i], cnt.get(ch[i])-1);
                i++;
            }
            if(set.size() == cnt.size())
                minLen = Math.min(minLen, j-i);

        }
        return minLen;
    }
}






