import java.util.*;

public class minOp {
    public static void main(String[] args)
    {
        System.out.print(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.print(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();

        int S = 0;
        for (int i : nums) S += i;
        S -= x;

        if (S == 0) return n;
        //map.put(0, -1);

        int op = Integer.MIN_VALUE;
        int rollingSum = 0;

        for (int i = 0; i < n; i++) {
            rollingSum += nums[i];

            if (map.containsKey(rollingSum - S))
                op = Math.max(op, i - map.get(rollingSum - S));
            //op = Math.min(op, map.get(rollingSum-(S-x))+1 + n-i-1);

            if (rollingSum == S) // map.put(0,-1);
                op = Math.max(op, i + 1);
            //op = Math.min(op, n-i-1);

            // no need to check containsKey since sum is unique
            map.put(rollingSum, i);
        }

        return op == Integer.MIN_VALUE ? -1 : n - op;
    }
}