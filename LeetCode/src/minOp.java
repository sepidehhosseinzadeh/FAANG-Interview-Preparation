import java.util.*;

public class minOp {
    public static void main(String[] args)
    {
        System.out.print(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.print(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    public static int minOperations_v0(int[] nums, int x) {
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

    public static int minOperations_v1(int[] nums, int x) {
        int n = nums.length, res = Integer.MAX_VALUE;
        int[] l = new int[n], r = new int[n];

        l[0] = nums[0];
        r[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) l[i] = l[i - 1] + nums[i];
        for (int i = n - 2; i >= 0; i--) r[i] = r[i + 1] + nums[i];

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(x, -1);
        for (int i = 0; i < n; i++) {
            if (l[i] == x) res = Math.min(res, i + 1);
            map.put(x - l[i], i);
        }
        for (int i = n - 1; i >= 0; i--)
            if (map.containsKey(r[i]))
                res = Math.min(res, map.get(r[i]) + 1 + n - i);

        return res == Integer.MAX_VALUE || res > n ? -1 : res;
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int S = 0; for(int i : nums) S += i;

        int l = 0, r = 0, res = Integer.MAX_VALUE;
        while(l <= r)
        {
            if(S >= x)
            {
                if(S == x) res = Math.min(res, l+n-r);
                if(r < n)   S -= nums[r++];
                else break;
            } else
                S += nums[l++];
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}