import java.util.*;

public class maxSumSubMatrix {
    public static void main(String[] args)
    {
    }
    static int getMaxSubMat(int[][] mat)
    {
        int bestSum = Integer.MIN_VALUE;
        int n = mat.length;
        int m = mat[0].length;
        for(int sr = 0; sr < n; sr++)
        {
            int[] partial = new int[m];
            for(int er = sr; er < n; er++)
            {
                for (int j = 0; j < m; j++)
                    partial[j] += mat[er][j];

                int maxSum = getMaxSum(partial);
                bestSum = Math.max(bestSum, maxSum);
            }
        }
        return bestSum;
    }
    static int getMaxSum(int[] arr)
    {
        int res = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            res = Math.max(res, sum);
            if(sum < 0)
                sum = 0;
        }
        return res;
    }
}
