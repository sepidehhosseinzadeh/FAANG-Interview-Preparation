import java.util.*;

public class maxBipartiteMatching {
    //  O(NM^2)
    public boolean canArrange(int[] nums, int k) {
        int[] pair = new int[nums.length];

        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
            if (match(i, nums, pair, k, new boolean[nums.length]))
                // every time a new array of visited, to prevent loop, but NOT new assignment -1!,
                // we are tying to find a best match for each i
                // (a math that other previous matches are preserved)
                cnt++;

        return cnt == nums.length;
    }

    boolean match(int at, int[] nums, int[] pair, int k, boolean[] vis)
    {
        for (int to = 0; to < nums.length; to++)
            if (!vis[to] && at != to && (nums[at] + nums[to]) % k == 0) {
                vis[to] = true;
                if (pair[to] == -1 || match(pair[to], nums, pair, k, vis)) {
                    pair[to] = at;
                    return true;
                }
            }
        return false;
    }
}
