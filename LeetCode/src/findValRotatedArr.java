import java.util.*;

public class findValRotatedArr {
    // idx of pivot is number of times rotated (shifted), so just everytime that you find mid idx in binary search, shift it to get the real mid!
    public int search_v0(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums);
        if(pivot == -1) return BinarySearch(nums, target, 0, n-1);
        int lb = 0, ub = n-1;
        while(lb <= ub)
        {
            int mid = lb + (ub-lb)/2;
            int realMid = (mid+pivot)%n; // just for comparing with target, but ub, lb will be updated using acuald mid, so that wwill be shifted
            if(nums[realMid] == target) return realMid;
            else if(nums[realMid] < target) lb = mid+1;
            else ub = mid-1;
        }
        return -1;
    }
    public int search_v1(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums);
        if (pivot == -1) return BinarySearch(nums, target, 0, n - 1);

        int idx = BinarySearch(nums, target, 0, pivot - 1);
        if (idx != -1) return idx;
        return BinarySearch(nums, target, pivot, n - 1);
    }

    int findPivot(int[] nums)
    {
        int n = nums.length;
        int lb = 0, ub = n - 1;
        if (nums[lb] <= nums[ub]) return -1;

        while (lb < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > nums[ub]) lb = mid + 1;
            else ub = mid;
        }
        return lb;
    }

    int BinarySearch(int[] nums, int target, int lb, int ub)
    {
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lb = mid + 1;
            else ub = mid - 1;
        }
        return -1;
    }
}