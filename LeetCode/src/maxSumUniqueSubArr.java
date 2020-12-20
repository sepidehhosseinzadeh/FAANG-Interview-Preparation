import java.util.*;

public class maxSumUniqueSubArr {
	public int maximumUniqueSubarray(int[] nums) {
		var set = new HashSet<Integer>();
		int sum = 0, max = 0;
		for(int i = 0, j = 0; j < nums.length;) {
			if(!set.contains(nums[j])) {
				set.add(nums[j]);
				sum += nums[j];
				max = Math.max(sum, max);
				j++;
			} else {
				set.remove(nums[i]);
				sum -= nums[i];
				i++;
			}
		}
		return max;
	}
}
