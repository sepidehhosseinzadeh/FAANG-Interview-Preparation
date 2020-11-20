import java.util.*;

public class maxSubArrSum {
    public int maxSubArray_v0(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    // divide and conquer
    // T(n) = 2T(n / 2) + O(1) -> O(n).

    int INF = Integer.MAX_VALUE;

    class val {
        int max = -INF; // max of arr
        int lmax = -INF; // max of a sequence which starts from left of arr
        int rmax = -INF; // max of a sequence which starts from right of arr
        int sum = -INF; // sum of arr
    }

    public int maxSubArray(int[] nums) {
        return maxSubArr(0, nums.length - 1, nums).max;
    }

    val maxSubArr(int lb, int rb, int[] nums)
    {
        if (lb >= rb) {
            val v = new val();
            v.max = v.lmax = v.rmax = v.sum = nums[lb];
            return v;
        }

        int mid = lb + (rb - lb) / 2;

        val l = maxSubArr(lb, mid, nums);
        val r = maxSubArr(mid + 1, rb, nums);

        val v = new val();
        v.lmax = Math.max(l.lmax, l.sum + r.lmax); // l.lmax [--->  ] left vector's lmax  OR
        // l.sum+r.lmax [-----]-->  left vector's sum+right vector's lmax

        v.rmax = Math.max(r.rmax, r.sum + l.rmax);

        v.max = Math.max(l.rmax + r.lmax,
                Math.max(l.max, r.max)); // max on left and right vector's max and middle max
        v.sum = l.sum + r.sum;
        v.max = Math.max(v.max, v.sum);

        return v;
    }
}