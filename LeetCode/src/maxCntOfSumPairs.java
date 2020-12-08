import java.util.*;

public class maxCntOfSumPairs {
	// O(nlon), O(1)
	public int maxOperations_v0(int[] nums, int k) {
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1, cnt = 0;
		while (i < j) {
			int s = nums[i] + nums[j];
			if (s > k) j--;
			else if (s < k) i++;
			else {
				cnt++;
				i++;
				j--;
			}
		}
		return cnt;
	}

	// O(n), O(n)
	public int maxOperations_v1(int[] nums, int k) {
		var pre = new HashMap<Integer, Integer>();

		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (pre.containsKey(k - nums[i]) && pre.get(k - nums[i]) > 0) {
				pre.put(k - nums[i], pre.get(k - nums[i]) - 1);
				cnt++;
				continue;
			}
			pre.put(nums[i], pre.getOrDefault(nums[i], 0) + 1);
		}
		return cnt;
	}

	// frequency: O(n), O(n)
	public int maxOperations(int[] nums, int k) {
		var freq = new HashMap<Integer, Integer>();
		for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);

		int cnt = 0;
		for (int num : freq.keySet()) {
			if (num == k - num) cnt += freq.get(num) / 2;
			else if (freq.containsKey(k - num) &&
					freq.get(k - num) > 0 && freq.get(num) > 0)
			{
				int minN = Math.min(freq.get(num), freq.get(k - num));
				freq.put(num, freq.get(num) - minN);
				freq.put(k - num, freq.get(k - num) - minN);

				cnt += minN;
			}
		}
		return cnt;
	}
}