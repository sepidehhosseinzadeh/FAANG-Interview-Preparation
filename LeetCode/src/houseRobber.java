import java.util.*;

public class houseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        memo = new int[n];
        Arrays.fill(memo, -1);

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], (i > 1 ? dp[i - 2] : 0) + nums[i]);
        }
        return dp[n - 1];
        //return rec(0, nums);
    }

    int[] memo;

    int rec(int at, int[] nums)
    {
        if (at >= nums.length) return 0;
        if (memo[at] != -1) return memo[at];

        return memo[at] = Math.max(nums[at] + rec(at + 2, nums),
                        rec(at + 1, nums));
    }

    public int rob_op(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}