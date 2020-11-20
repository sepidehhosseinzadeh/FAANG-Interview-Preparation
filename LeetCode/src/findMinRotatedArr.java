import java.util.*;

public class findMinRotatedArr {
    // first elem after inflation point is min (first elem in original arr)
    public int findMin_v0(int[] nums) {
        int n = nums.length;
        int lb = 0, ub = n - 1;
        if (nums[lb] < nums[ub]) return nums[lb]; // no rotation
        if (n == 1) return nums[0];
        if (n == 2) return Math.min(nums[0], nums[1]);

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[ub]) lb = mid;
            if (nums[mid] < nums[lb]) ub = mid;
        }

        return -1;
    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int lb = 0, ub = n-1;

        while(lb < ub)
        {
            int mid = lb + (ub-lb)/2;
            if(nums[mid] > nums[ub]) lb = mid+1;

                // we know that nums[mid] <= nums[right].
                // therefore, we know it is possible for the mid index to store a smaller
                // value than at least one other index in the list (at right), so we do
                // not discard it by doing right = mid - 1. it still might have the minimum value.
            else ub = mid;
        }

        //
        // hen left bound increases, it does not disqualify a value
        // that could be smaller than something else (we know nums[mid] > nums[right],
        // so nums[right] wins and we ignore mid and everything to the left of mid).

        // when right bound decreases, it also does not disqualify a
        // value that could be smaller than something else (we know nums[mid] <= nums[right],
        // so nums[mid] wins and we keep it for now).

        // so we shrink the left/right bounds to one value,
        // without ever disqualifying a possible minimum
        return nums[lb];
    }
}

