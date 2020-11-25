import java.util.*;

public class houseRobberCircular {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        return Math.max(rob1(nums, 1, n - 1), rob1(nums, 0, n - 2));
    }

    public int rob1(int[] nums, int l, int h) {
        int[] dp = new int[h + 1];
        dp[l] = nums[l];
        for (int i = l + 1; i <= h; i++)
            dp[i] = Math.max(dp[i - 1], (i > l + 1 ? dp[i - 2] : 0) + nums[i]);

        return dp[h];
    }
    int rob1_op(int[] num, int l, int r) {
        int include = 0, exclude = 0;
        for (int j = l; j <= r; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
    int rob1_op1(int[] nums, int l, int r) {
        int pre = 0, cur = 0;
        for (int i = l; i <= r; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}