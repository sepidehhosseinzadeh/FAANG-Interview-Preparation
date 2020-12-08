import java.util.*;

public class LongestIncSeq {
    // O(n^2)
    public int lengthOfLIS_v0(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, len = 0;
        int[] lis = new int[n]; // inc subseq
        // (1) if x is larger than all tails, append it, increase the size by 1
        // (2) if tails[i-1] < x <= tails[i], update tails[i]
        for (int i = 0; i < n; i++) {
            // find pos of lis[k-1] < nums[i] <= lis[k] in lis
            int lb = 0, ub = len;
            while (lb < ub) {
                int mid = lb + (ub - lb) / 2;
                if (nums[i] > lis[mid]) lb = mid + 1;
                else ub = mid;
            }
            lis[lb] = nums[i];
            if (lb == len) len++;
        }
        return len;
    }

    public int lengthOfLIS_v1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
