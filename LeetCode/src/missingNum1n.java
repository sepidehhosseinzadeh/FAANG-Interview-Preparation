import java.util.*;
import java.util.stream.IntStream;

public class missingNum1n {
    // 0. XOR
    public int missingNumber_v0(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res ^ n;
    }

    //1.XOR
    public int missingNumber_v1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    //2.SUM
    public int missingNumber_v2(int[] nums) {
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for (int i = 0; i < len; i++)
            sum -= nums[i];
        return sum;
    }

    //3.Binary Search
    public int missingNumber_v3(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public int missingNumber(int[] nums) {
        long n = nums.length;
        return (int) (n * (n+1) / 2 - IntStream.of(nums).sum());
    }
}