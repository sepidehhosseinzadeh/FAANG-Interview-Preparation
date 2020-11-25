import java.util.*;

public class combinationSumiv {
    public static void main(String[] arg)
    {
        System.out.print(combinationSum(new int[]{2,3,6,7}, 7));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 0; j <= target; j++)
            for (int i = 0; i < n; i++)
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
        return dp[target];
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        var dp = new ArrayList[target + 1];

        for (int j = 0; j <= target; j++) {
            dp[j] = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++)
                if (j >= nums[i]) {
                    for (int k = 0; k < dp[j - nums[i]].size(); k++) {
                        ArrayList<Integer> t = (ArrayList<Integer>) dp[j - nums[i]].get(k);
                        t.add(nums[i]);
                        dp[j].add(t);
                    }
                }
        }
        return dp[target];
    }
}

