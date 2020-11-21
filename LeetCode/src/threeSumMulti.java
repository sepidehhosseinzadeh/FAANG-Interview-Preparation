import java.util.*;

public class threeSumMulti {
    public int threeSumMulti_v0(int[] nums, int target) {
        long res = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i + 2 < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r)
                if (nums[i] + nums[l] + nums[r] == target) {
                    // after you add l and r, then skip duplicates
                    int nl = 1, nr = 1;
                    while (l + nl <= r && nums[l] == nums[l + nl]) nl++;
                    while (r - nr >= l && nums[r] == nums[r - nr]) nr++;

                    // if nums[l]==nums[r] : C(nl....nr, 2) else nl*nr
                    res += nums[l] == nums[r] ? (r - l) * (r - l + 1) / 2 : nl * nr;
                    l += nl;
                    r -= nr; // move both
                }
                else if (nums[i] + nums[l] + nums[r] > target) r--;
                else l++;
        }

        return (int) (res % 1_000_000_007);

    }

    public int threeSumMulti(int[] nums, int target) {
        long res = 0;
        long[] cnt = new long[101];
        for (int i : nums) cnt[i]++;

        for (int i = 0; i < 101; i++)
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k) res += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                    //else if(i == j && j != k) res += cnt[i]*(cnt[i]-1)/2*cnt[k];
                else if (i == j && (j < k || k < j)) res += cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                else if (i < j && j < k) res += cnt[i] * cnt[j] * cnt[k];
            }
        return (int) (res % 1_000_000_007);
    }
}