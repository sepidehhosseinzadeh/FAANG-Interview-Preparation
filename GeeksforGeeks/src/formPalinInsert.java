/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

/*
find the minimum number of char to be inserted to convert it to palindrome.
 */
class formPalinInsert {
    static int INF = Integer.MAX_VALUE;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            String s = sc.nextLine();
            System.out.println(minPalinInsert(s.toCharArray()));
        }
    }
    static int minPalinInsert(char[] ch)
    {
        int n = ch.length;
        int[][] minInsPalin = new int[n][n];
        for(int[] i:minInsPalin)
            Arrays.fill(i, n);
        for(int i = 0; i < n; i++)
            minInsPalin[i][i] = 0;
        for(int i = 0; i+1 < n; i++)
            minInsPalin[i][i+1] = ch[i] == ch[i+1] ? 0 : 1;

        for(int l = 0; l < n; l++)
            for(int i = 0; i+l < n; i++)
            {
                int j = i+l;

                if(i+1 < n && j > 0 && ch[i] == ch[j])
                    minInsPalin[i][j] = Math.min(minInsPalin[i][j],
                            minInsPalin[i+1][j-1]);
                else
                    minInsPalin[i][j] = Math.min(minInsPalin[i][j],
                            1+Math.min(i+1>=n?INF:minInsPalin[i+1][j],
                                        j==0?INF:minInsPalin[i][j-1]));
            }

        return minInsPalin[0][n-1];
    }
}


