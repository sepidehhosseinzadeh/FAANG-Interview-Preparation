import java.util.*;

// https://leetcode.com/problems/product-of-array-except-self/
public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) return nums;

        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for(int i = 1; i < nums.length; i++)
            res[i] = res[i-1]*nums[i-1];
        int r = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            res[i] *= r;
            r *= nums[i];
        }

        return res;
    }
}
