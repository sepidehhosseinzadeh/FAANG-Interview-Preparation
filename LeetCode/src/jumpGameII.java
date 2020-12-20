import java.util.*;

public class jumpGameII {
	public static void main(String[] args)
	{
		System.out.print(maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
	}
	public static  int maxResult(int[] nums, int k) {
		int n = nums.length, max = 0;

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MIN_VALUE);

		dp[0] = nums[0];

		for(int i = 0; i < n; i++)
			for(int j = 1; j <= k && i+j < n; j++) {
				dp[i+j] = Math.max(dp[i+j], dp[i] + nums[i+j]);
				if(i+j == n-1) max = Math.max(dp[i+j], max);
			}

		return max;
	}
}
