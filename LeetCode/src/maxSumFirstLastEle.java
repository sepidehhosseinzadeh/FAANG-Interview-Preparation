import java.util.*;

public class maxSumFirstLastEle {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 5, 7, 1};
        int k1 = 3;
        int[] nums2 = {5, 10, 2, 9, 11};
        int k2 = 3;
        System.out.println(getMaxSumDp(nums1, k1));
        System.out.println(getMaxSumDp(nums2, k2));
    }

    private static int getMaxSumDp_v0(int[] nums, int K) {
        int[][][] dp = new int[nums.length][nums.length][K + 1];

        for (int l = 0; l < nums.length; l++)
            for (int i = 0; i + l < dp.length; i++)
                for (int k = 1; k <= K; k++)
                    if (l == 0)
                        dp[i][i][k] = nums[i];
                    else
                        dp[i][i + l][k] = Math.max(nums[i] +
                                dp[i + 1][i + l][k - 1], nums[i + l] + dp[i][i + l - 1][k - 1]);

        return dp[0][nums.length - 1][K];
    }

    private static int getMaxSumDp(int[] nums, int K) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                if (l == 0)
                    dp[i][i] = nums[i];
                else
                    dp[i][i + l] = Math.max(nums[i] +
                            dp[i + 1][i + l], nums[i + l] + dp[i][i + l - 1]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; n-K+i < n; i++)
            res = Math.max(res, dp[i][n-K+i]);

        return res;
    }
}
