import java.util.*;

public class bestStrategyGame {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int[][] memo = new int[n][n];
            for(int[] a : memo) Arrays.fill(a, -1);
            //System.out.println(maxVal(0, n-1, arr, memo));
            System.out.println(maxValDP(arr));
        }
    }
    static int maxVal(int l, int r, int[] arr, int[][] memo)
    {
        if(l > r)   return 0;
        if(l == r)  return arr[l];
        if(r == l+1)  return Math.max(arr[l], arr[r]);

        if(memo[l][r] != -1)
            return memo[l][r];

        // pick l, opp picks such that I get min from rest
        int ls = arr[l]+Math.min(maxVal(l+2, r, arr, memo),
                maxVal(l+1, r-1, arr, memo));

        // pick r
        int rs = arr[r]+Math.min(maxVal(l+1, r-1, arr, memo),
                maxVal(l, r-2, arr, memo));

        return memo[l][r] = Math.max(ls, rs);
    }
    static int maxValDP(int[] val)
    {
        int n = val.length;
        int[][] maxVal = new int[n][n];

        for(int i = 0; i < n; i++)
            maxVal[i][i] = val[i];

        for(int l = 0; l < n; l++)
            for(int i = 0; i+l < n; i++)
            {
                int j = i+l;
                maxVal[i][j] = Math.max(
                        val[i]+Math.min(i+2>j?0:maxVal[i+2][j], i+1>j-1?0:maxVal[i+1][j-1]), // pick i
                        val[j]+Math.min(i+1>j-1?0:maxVal[i+1][j-1], i>j-2?0:maxVal[i][j-2]) // pick j
                );
            }

        return maxVal[0][n-1];
    }
}

