import java.util.*;

public class jumpGame {
    public boolean canJump_dp(int[] nums) {
        int n = nums.length;
        boolean[] can = new boolean[n];
        can[0] = true;
        for(int i = 0; i < n; i++)
            for(int j = 0; j <= nums[i]; j++)
                can[(i+j)%n] |= can[i];
        return can[n-1];
    }
    // greedy
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farest = 0;
        for(int i = 0; i < n; i++)
        {
            if(farest < i) return false;
            farest = Math.max(farest, i+nums[i]);
            if(farest >= n-1) return true;
        }
        return false;
    }
}
