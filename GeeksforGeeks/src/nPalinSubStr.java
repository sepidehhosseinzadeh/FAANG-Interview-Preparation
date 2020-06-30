/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;

class nPalinSubStr {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();

            String s = sc.nextLine();
            System.out.println(cntPalin(s.toCharArray()));
        }
    }
    static int cntPalin(char[] ch)
    {
        int n = ch.length;
        int[][] cnt = new int[n][n];
        boolean[][] isPalin = new boolean[n][n];
        for(int i = 0; i < n; i++)
            isPalin[i][i] = true;
        for(int i = 0; i+1 < n; i++)
        {
            if(ch[i] == ch[i+1])
                isPalin[i][i+1] = true;
        }

        for(int l = 1; l < n; l++)
            for(int i = 0; i+l < n; i++)
            {
                int j = i+l;
                if (isPalin[i][j] || (isPalin[i][j]=isPalin(ch, i, j)))
                    cnt[i][j] = cnt[i+1][j]+cnt[i][j-1]+1-cnt[i+1][j-1];
                else
                    cnt[i][j] = cnt[i+1][j]+cnt[i][j-1]-cnt[i+1][j-1];
            }
        return cnt[0][n-1];
    }

    private static boolean isPalin(char[] ch, int i, int j) {
        while(i < j)
        {
            if(ch[i]!=ch[j])    return false;
            i++;j--;
        }
        return true;
    }
}



