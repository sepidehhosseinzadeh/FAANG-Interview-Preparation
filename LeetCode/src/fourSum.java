import java.util.*;

public class fourSum {
    public static void main(String[] args)
    {
        int[] num = new int[] {1,0,-1,0,-2,2};
        System.out.println(fourSum(num,0));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int k = 0; k < nums.length; k++)
        {
            for(int p = k+1; p < nums.length; p++)
            {
                int a = nums[k]+nums[p];
                int s = target-a;

                int i = 0, j = nums.length-1;
                while(i < j)
                {
                    if(i == k || i == p) i++;
                    if(i >= j) break;
                    if(j == k || j == p) j--;
                    if(j <= i) break;

                    if(nums[i]+nums[j] == s)
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[k]);
                        list.add(nums[p]);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        res.add(list);
                    }
                    else if(nums[i]+nums[j] > s) j--;
                    else i++;
                }
            }
        }

        return res;
    }

    // recursive solution
    public static List<List<Integer>> fourSum_v1(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }
}
