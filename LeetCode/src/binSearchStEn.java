import java.util.*;

public class binSearchStEn {
    // Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        int[] none = new int[]{-1, -1};

        if (nums.length == 0) return none;

        int st = bs(nums, target - 0.5), en = bs(nums, target + 0.5) - 1;
        if (st > en) return none;

        return new int[]{st, en};
    }

    int bs(int[] nums, double target)
    {
        int lb = 0, ub = nums.length - 1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] < target)
                lb = mid + 1;
            else
                ub = mid - 1;
        }
        return lb;
    }
}

