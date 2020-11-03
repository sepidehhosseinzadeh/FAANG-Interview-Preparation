import java.util.*;

public class trapWaterHistogram {
    public int trap(int[] height)
    {
        int n = height.length;
        if (n == 0) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        int water = 0;
        for (int i = 0; i < n; i++)
            water += Math.min(rightMax[i], leftMax[i]) - height[i];

        return water;
    }

    public int trap_v1(int[] h) {
        int n = h.length;
        int res = 0;

        int i = 0, j = n - 1;
        int lmax = 0, rmax = 0;
        while (i < j) {
            if (h[i] <= h[j]) { // flow water from left, becuz h[j] is higher, so it's not holing any water now.
                if (lmax < h[i]) lmax = h[i];
                else res += lmax - h[i];
                i++;
            }
            else {
                if (rmax < h[j]) rmax = h[j];
                else res += rmax - h[j];
                j--;
            }
        }
        return res;
    }
}