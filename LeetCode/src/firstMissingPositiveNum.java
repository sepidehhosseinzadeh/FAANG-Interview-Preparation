import java.util.*;

public class firstMissingPositiveNum {
    public static void main(String[] args)
    {
        System.out.print(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    // 1 - using xor of nums 1 to n with nums
    // using HashSet
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++)
            if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;

        for (int i : nums)
            if (Math.abs(i) - 1 < n && nums[Math.abs(i) - 1] >= 0)
                nums[Math.abs(i) - 1] = -nums[Math.abs(i) - 1];

        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                return i + 1;

        return n + 1;
    }
}
