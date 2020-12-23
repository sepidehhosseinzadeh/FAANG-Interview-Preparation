import java.util.*;

public class maxSubArrSum {
    public int maxSubArray_v0(int[] nums) {
        int prevS = nums[0];
        int maxS = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prevS = Math.max(nums[i], prevS+nums[i]);
            maxS = Math.max(prevS, maxS);
        }
        return maxS;
    }
    public int maxSubArray_v1(int[] nums) {
        int S = 0;
        int maxS = nums[0];
        for(int i = 0; i < nums.length; i++) {
            S = Math.max(0, S);
            S += nums[i];
            maxS = Math.max(S, maxS);
        }
        return maxS;
    }
    public int maxSubArray_v2(int[] nums) {
        int[] dp = new int[nums.length];
        int maxS = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i]+(dp[i-1] > 0 ? dp[i-1] : 0);
            maxS = Math.max(maxS, dp[i]);
        }
        return maxS;
    }
    public int maxSubArray_v3(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0)
                sum = 0;
        }
        return max;
    }




    // divide and conquer
    // T(n) = 2T(n / 2) + O(1) -> O(n).

    public int maxSubArray_v4(int[] nums) {
        return maxS(0, nums.length-1, nums);
    }
    int maxS(int l, int r, int[] nums) {
        if(l > r) return Integer.MIN_VALUE;
        if(l == r) return nums[l];

        int mid = l+(r-l)/2;
        int sl = maxS(l, mid, nums);
        int sr = maxS(mid+1, r, nums);

        int sm = nums[l], s = 0;
        for(int i = l; i <= r; i++) {
            if(s < 0) s = 0;
            s += nums[i];
            sm = Math.max(sm, s);
        }

        int maxs = Math.max(Math.max(sl, sr), sm);
        return maxs;
    }


    int INF = Integer.MAX_VALUE;
    class val
    {
        int max=-INF; // max of arr
        int lmax=-INF; // max of a sequence which starts from left of arr
        int rmax=-INF; // max of a sequence which starts from right of arr
        int sum=-INF; // sum of arr
    }
    public int maxSubArray(int[] nums) {
        return maxSubArr(0, nums.length-1, nums).max;
    }
    val maxSubArr(int lb, int rb, int[] nums)
    {
        if(lb >= rb)
        {
            val v = new val();
            v.max = v.lmax = v.rmax = v.sum = nums[lb];
            return v;
        }

        int mid = lb+(rb-lb)/2;

        val l = maxSubArr(lb, mid, nums);
        val r = maxSubArr(mid+1, rb, nums);

        val v = new val();
        v.lmax = Math.max(l.lmax, l.sum+r.lmax); // l.lmax [--->  ] left vector's lmax  OR   l.sum+r.lmax [-----]-->  left vector's sum+right vector's lmax

        v.rmax = Math.max(r.rmax, r.sum+l.rmax);

        v.max = Math.max(l.rmax+r.lmax,
                Math.max(l.max, r.max)); // max on left and right vector's max and middle max
        v.sum = l.sum+r.sum;
        v.max = Math.max(v.max, v.sum);

        return v;
    }
}
