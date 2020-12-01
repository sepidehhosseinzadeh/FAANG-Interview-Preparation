import java.util.*;

public class minSeq {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        var stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            // If cur elem is smaller, then replacing it will give us a smaller seq.
            // If there are enough elem, then pop.
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() - 1 + n - i >= k)
                stack.pop();

            // if there are more or equal than k nums, then the seq is smaller, no need to add.
            if (stack.size() < k) stack.push(nums[i]);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    /*We need to fill k slots.
    To fill the first slot, we should pick the smallest number between index [0] ~ [N-k] (inclusive)
        (we have to preserve at least k-1 numbers for the rest of k-1 slots)
    For the ith (0-indexed) slot, we should pick the smallest number
        between index [previous picked index + 1] ~ [N-k+i] (range of the window)
    We keep a increasing monotonic queue for the window, and use the smallest number (front of the queue)
    Note:
        We only need at most k numbers in the queue
        we allow equal numbers in the queue
    */
    public int[] mostCompetitive_v1(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((i, j) -> i[0] != j[0] ? i[0] - j[0] : i[1] - j[1]);
        for (int j = 0; j <= nums.length - k; j++) q.add(new int[]{nums[j], j});
        int[] res = new int[k];
        int i = 0;

        int preIdx = -1;
        while (k > 0) {
            int[] min = q.poll();
            if (preIdx != -1)
                while (min[1] < preIdx)
                    min = q.poll();

            res[i++] = min[0];
            preIdx = min[1];
            k--;
            if (k > 0)
                q.add(new int[]{nums[nums.length - k], nums.length - k});
        }
        return res;
    }

    public int[] mostCompetitive_v0(int[] nums, int k) {
        int[] res = new int[k];
        int i = 0;
        int pre = -1;
        while (k > 0) {
            int min = Integer.MAX_VALUE;
            for (int j = pre + 1; j <= nums.length - k; j++)
                if (min > nums[j]) {
                    min = nums[j];
                    pre = j;
                }

            res[i++] = min;
            k--;
        }
        return res;
    }
}