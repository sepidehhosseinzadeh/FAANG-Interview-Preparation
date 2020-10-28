import java.util.*;

public class arrayPairsDivK {
    public static void main(String[] args)
    {
        System.out.print(canArrange(new int[]{3, 8, 17, 2, 5, 6}, 10));
    }

    // Given 2 nums 'a' and 'b':
    //If a % k == x and b % k == k - x :
    //then (a + b) is divisible by k
    
    //Proof :
    //a % k == x
    //b % k == k - x
    //(a + b) % k = ((a + b)%k)%k = (a%k + b%k)%k = (x + k - x)%k = k%k = 0
    //Hence, (a + b) % k == 0 and (a + b) is divisible by k.
    public static boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[k];
        for(int num : arr){
            num %= k;
            if(num < 0) num += k;
            cnt[num]++;
        }
        if(cnt[0]%2 != 0) return false;

        for(int i = 1; i <= k/2; i++)
            if(cnt[i] != cnt[k-i]) return false;

        return true;
    }

    // max bipartite matctching solution O(NM^2)
    public static boolean canArrange_v1(int[] nums, int k) {
        int[] pair = new int[nums.length];
        Arrays.fill(pair, -1);
        boolean[] vis = new boolean[nums.length];

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(vis, false);
            if (match(i, nums, pair, k, vis))
                cnt++;
        }
        return cnt == nums.length;
    }

    static boolean match(int at, int[] nums, int[] pair, int k, boolean[] vis)
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

