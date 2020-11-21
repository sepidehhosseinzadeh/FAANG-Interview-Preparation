import java.util.*;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int dis = res;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i + 2 < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip uplicates
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (Math.abs(target - (nums[i] + nums[l] + nums[r])) < dis) {
                    dis = Math.abs(target - (nums[i] + nums[l] + nums[r]));
                    res = nums[i] + nums[l] + nums[r];
                }
                if (nums[i] + nums[l] + nums[r] == target) return res;
                if (nums[i] + nums[l] + nums[r] > target) r--;
                else l++;
            }
        }

        return res;
    }
}
