import java.util.*;
import java.lang.*;
import java.io.*;

public class minPalPartition {
    static int INF = Integer.MAX_VALUE;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0)
        {
            String s = sc.nextLine();
            System.out.println(minPalPartition(s.toCharArray()));
        }
    }
    static int minPalPartition(char[] ch)
    {
        int n = ch.length;
        int[][] minPal = new int[n][n];

        for(int[] a: minPal)
            Arrays.fill(a, INF);

        for(int l = 0; l < n; l++)
            for(int i = 0; i+l < n; i++)
            {
                int j = i+l;
                if(isPal(ch, i, j))
                    minPal[i][j] = 0;
                else
                {
                    int minP = INF;
                    for(int k = i; k < j; k++)
                        if(minPal[i][k]!= INF && minPal[k+1][j]!=INF)
                            minP = Math.min(minP, minPal[i][k]+minPal[k+1][j]);
                    minPal[i][j] = 1+minP;
                }
            }

        return minPal[0][n-1];
    }
    static boolean isPal(char[] ch, int s, int e)
    {
        while(s < e)
        {
            if(ch[s] != ch[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}




