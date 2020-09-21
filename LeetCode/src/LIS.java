import java.util.*;
// Longest Increasing Subsequence
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int max = 0;

        for (int e = 0; e < n; e++) {
            for (int s = 0; s < e; s++)
                if (nums[e] > nums[s])
                    lis[e] = Math.max(lis[e], lis[s] + 1);

            max = Math.max(max, lis[e]);
        }

        return max;
    }
}
