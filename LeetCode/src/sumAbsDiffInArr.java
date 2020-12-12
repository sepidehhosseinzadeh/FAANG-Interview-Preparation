import java.util.*;

public class sumAbsDiffInArr {
	// if we didn't care about difference, then it's just
	// n*nums[i] - sum[1...n]
	// now that there is absoloute value is important,
	// we need to know which numbers are negative/positive.
	// so, n*nums[i] is devided to two parts:
	// i*nums[i] and (n-i)*nums[i]
	// the first part minus sum[1...i] (nums less than nums[i]),
	// and sum[i+1...n] minus second part
	// to simplify: i*nums[i]-left + right-(n-i-1)*nums[i]

	public int[] getSumAbsoluteDifferences(int[] nums) {
		int sum = 0, n = nums.length;
		for(int i : nums) sum += i;

		int[] res = new int[n];
		int left = 0, right = sum;
		for(int i = 0; i < n; i++) {
			right -= nums[i];
			res[i] = i*nums[i] - left + right - (n-i-1)*nums[i];
			left += nums[i];
		}
		return res;
	}
}