import java.util.*;

public class distributeNumbers {
    // n: len(nums), m: len(quantity) ->  O(n^m)
    public boolean canDistribute_v0(int[] nums, int[] quantity) {
        var map = new HashMap<Integer, Integer>();
        for(int i : nums) map.put(i, map.getOrDefault(i,0)+1);

        int j = 0;
        int[] cnt = new int[map.size()];
        for(int i : map.values())
            cnt[j++] = i;

        Arrays.sort(quantity);
        // sort the quantity list in descending order -
        // once we find the biggest order left cannot be satisfied,
        // it fails, we don't need to worry about the rest
        // (otherwise it will go TLE).

        return canAssign_v0(quantity.length-1, cnt, quantity);
    }

    boolean canAssign_v0(int at, int[] cnt, int[] quantity)
    {
        if(at < 0) return true;

        for(int i = 0; i < cnt.length; i++)
            if(cnt[i] >= quantity[at]) {

                cnt[i] -= quantity[at];
                if(canAssign_v0(at-1, cnt, quantity)) return true;
                cnt[i] += quantity[at];
            }

        return false;
    }

    // for each num, assign a subset f orders (2^m) -> O((2^m)^n) TLE!!!
    // it should be bottom up! it's NOT using memo!
    boolean[][] memo;
    int n, m;
    public boolean canDistribute_v1(int[] nums, int[] quantity) {
        var map = new HashMap<Integer, Integer>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int j = 0;
        int[] cnt = new int[map.size()];
        for (int i : map.values())
            cnt[j++] = i;

        n = cnt.length; m = quantity.length;
        int[] required = new int[1<<m];
        for(int i = 0; i < 1<<m; i++)
            for(j = 0; j < m; j++)
                if((1<<j & i) != 0)
                    required[i] += quantity[j];

        memo = new boolean[n][1<<m];

        return canAssign_v1(0, 0, cnt, required);
    }
    boolean canAssign_v1(int at, int selectedMask, int[] cnt, int[] required)
    {
        if(selectedMask == (1<<m)-1) return true; // all customers are served
        if(at == n) return false;
        if(memo[at][selectedMask]) return memo[at][selectedMask];

        // potential candidates to be assigned to cnt[at]
        for(int i = 0; i < 1<<m; i++)
            if((selectedMask & i) == 0)
                if(required[i] <= cnt[at])
                    if(canAssign_v1(at+1, selectedMask | i, cnt, required))
                        return memo[at][selectedMask] = true;

        return false;
    }

    // bottom-up
    


}