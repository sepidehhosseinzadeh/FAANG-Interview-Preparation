import java.util.*;

public class threeSum {
    public List<List<Integer>> threeSum_v0(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i + 2 < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip uplicates
            int l = i + 1, r = n - 1;
            while (l < r)
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // after you add l and r, then skip duplicates
                    while (l + 1 <= r && nums[l] == nums[l + 1]) l++;
                    while (r - 1 >= l && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--; // move both
                }
                else if (nums[i] + nums[l] + nums[r] > 0) r--;
                else l++;
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i+2 < n; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue; // skip uplicates
            int l = i+1, r = n-1;
            while(l < r) {
                // before adding, compare with previous
                while(l-1 > i && l+1 <= r && nums[l] == nums[l-1]) l++;
                while(r+1 < n && r-1 >= l && nums[r] == nums[r+1]) r--;
                if(l == r) continue;

                if(nums[i]+nums[l]+nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // after you add l and r, then skip duplicates!!!
                    // compare with next
                    l++;r--; // move both
                } else if(nums[i]+nums[l]+nums[r] > 0) r--;
                else l++;
            }
        }

        return res;
    }
}
