import java.util.*;

public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque q = new ArrayDeque<Integer>();
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i = 0, j = 0; i < n; i++) {
            // rm unnessary
            while(!q.isEmpty() && (int)q.peekFirst() <= i-k) q.pollFirst();

            while(!q.isEmpty() && nums[(int)q.peekLast()] < nums[i]) q.pollLast();
            q.addLast(i);

            if(i >= k-1) res[j++] = nums[(int)q.peekFirst()];

        }
        return res;

    }
}

