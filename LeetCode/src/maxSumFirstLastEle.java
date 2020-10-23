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
        int n = nums.length;
        int[][][] dp = new int[n][n][K + 1];

        for (int l = 0; l < n; l++)
            for (int i = 0; i + l < n; i++)
                for (int k = 1; k <= K; k++)
                    if (l == 0)
                        dp[i][i][k] = nums[i];
                    else
                        dp[i][i + l][k] = Math.max(nums[i] +
                                dp[i + 1][i + l][k - 1], nums[i + l] + dp[i][i + l - 1][k - 1]);

        return dp[0][n - 1][K];
    }

    private static int getMaxSumDp(int[] nums, int K) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                if (l == 0)
                    dp[i][i] = nums[i];
                else
                    dp[i][i + l] = Math.min(nums[i] +
                            dp[i + 1][i + l], nums[i + l] + dp[i][i + l - 1]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; n-K+i < n; i++)
            res = Math.max(res, dp[i][n-K+i]);

        return res;
    }

    static int res = Integer.MIN_VALUE;

    private static int getMaxSum(int[] nums, int k) {
        res = Integer.MIN_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for(int n : nums) {
            q.offer(n);
        }
        dfs(q, k, 0);
        return res;
    }

    private static void dfs(Deque<Integer> q, int k, int tmp) {
        if(q.isEmpty() || k == 0) {
            res = Math.max(res, tmp);
            return;
        }
        int first = q.pollFirst();
        dfs(q, k-1, tmp + first);
        q.offerFirst(first);
        int last = q.pollLast();
        dfs(q, k-1, tmp + last);
        q.offerLast(last);
    }

    /*
    // Memo
    def largestSumFromEnd(nums, multiply, K):
    memo = {}

    def dp(i, j, k, sum):
        if (i, j, k) in memo:
            return memo[i, j, k]
        if k == K:
            return sum
        else:
            memo[i, j, k] = max(dp(i + 1, j, k + 1, sum + nums[i] * multiply[k]),
                                dp(i, j + 1, k + 1, sum + nums[-(j+1)] * multiply[k]))
            return memo[i, j, k]

    ans = dp(0, 0, 0, 0)
    return ans
     */
}
