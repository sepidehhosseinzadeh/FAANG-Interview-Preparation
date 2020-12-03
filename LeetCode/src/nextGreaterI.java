import java.util.*;

public class nextGreaterI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        var res = new HashMap<Integer, Integer>();
        var stack = new Stack<Integer>();

        for(int i = 0; i < m; i++) {
            // all the elem in stack (previous elem) now see a greater num
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                res.put(stack.pop(), nums2[i]);

            stack.push(nums2[i]);
        }

        int[] ret = new int[n];
        int i = 0;
        for(int v : nums1)
            ret[i++] = res.getOrDefault(v, -1);

        return ret;

    }
    public int[] nextGreaterElement_v0(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        var res = new HashMap<Integer, Integer>();
        var stack = new Stack<Integer>();

        for(int i = m-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                int cur = stack.pop();
                res.put(cur, !stack.isEmpty() ? stack.peek() : -1);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()) {
            int cur = stack.pop();
            res.put(cur, !stack.isEmpty() ? stack.peek() : -1);
        }

        int[] ret = new int[n];
        int i = 0;
        for(int v : nums1)
            ret[i++] = res.get(v);

        return ret;

    }
}
