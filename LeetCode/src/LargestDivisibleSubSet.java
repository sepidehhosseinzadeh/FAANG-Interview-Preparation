import java.util.*;
/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */
public class LargestDivisibleSubSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] maxSubTill = new int[n];
        int[] prev = new int[n];

        Arrays.sort(nums);

        int max = 0, idx = -1;
        for (int i = 0; i < n; i++) {
            maxSubTill[i] = 1;
            prev[i] = -1;

            for (int j = i - 1; j >= 0; j--)
                if (nums[i] % nums[j] == 0 && maxSubTill[i] < maxSubTill[j] + 1) {
                    maxSubTill[i] = maxSubTill[j] + 1;
                    prev[i] = j;
                }
            if (max < maxSubTill[i]) {
                max = maxSubTill[i];
                idx = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (idx != -1) {
            res.add(0, nums[idx]);
            idx = prev[idx];
        }

        return res;
    }
}