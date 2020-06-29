/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;

class nPalinSubStr {
    static class Index
    {
        int x, y;
        Index(int X, int Y)
        {
            x = X; y = Y;
        }
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();

            String s = sc.nextLine();
            System.out.println(count(s.toCharArray(), 0,
                        s.length()-1,  new HashSet<Index>()));
        }
    }
    static int count(char[] ch, int s, int e, HashSet<Index> seen)
    {
        if(s > e)   return 0;
        if(s == e)   return 1;

        int cnt = 0;
        for(int i = s; i <= e; i++)
        {
            Index at = new Index(s, i);
            if (!seen.contains(at) && isPalin(ch, s, i))
            {
                seen.add(at);
                cnt += count(ch, i + 1, e, seen);
                seen.remove(at);
            }
        }
        return cnt;
    }
    static boolean isPalin(char[] ch, int s, int e)
    {
        //if(s==e)    return false;
        int i = s, j = e;
        while(i < j)
        {
            if(ch[i] != ch[j])  return false;
            i++; j--;
        }
        return true;
    }
}



