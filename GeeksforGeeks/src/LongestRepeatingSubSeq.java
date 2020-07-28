import java.util.*;
import java.lang.*;

class LongestRepeatingSubSeq {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            sc.nextLine();

            char[] s = sc.nextLine().toCharArray();

            System.out.println(LCS(s,s));
        }
    }
    // LCS on itself with not same index
    static int LCS(char[] a, char[] b)
    {
        int na = a.length, nb = b.length;
        int[][] lcs = new int[na+1][nb+1];

        for(int i = 1; i <= na; i++)
            for(int j = 1; j <= nb; j++)
                if(i != j&& a[i-1] == b[j-1])
                    lcs[i][j] = lcs[i-1][j-1]+1;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j],
                                        lcs[i][j-1]);

        return lcs[na][nb];
    }
}