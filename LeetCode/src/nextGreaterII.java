import java.util.*;

public class nextGreaterII {
    // If we store values instead of index, we will get wrong ans for
    // duplicate values:
    // Input    [100,1,11,1,120,111,123,1,-1,-100]
    // Output   [120,120,120,120,123,123,-1,120,100,100]
    // Expected [120,11,120,120,123,123,-1,100,100,100]

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // var res = new HashMap<Integer, Integer>(); // WRONG!!! duplicate exists
        int[] res = new int[n];
        Arrays.fill(res, -1);
        var stack = new Stack<Integer>();

        for (int i = 0; i < 2 * n; i++) { // copy arr twice for circular arr
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                res[stack.pop()] = nums[i % n];

            stack.push(i % n);
        }

        return res;
    }
}