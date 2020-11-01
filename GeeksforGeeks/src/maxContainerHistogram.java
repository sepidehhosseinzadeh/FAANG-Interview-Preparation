import java.util.*;

public class maxContainerHistogram {
    // Container With Most Water:
        // Because the length is always decreasing
        // we only need to consider a pair if its height
        // is greater than any pair's height we've used so far
    public int maxArea(int[] h) {
        int n = h.length;
        int maxArea = 0;
        int i = 0, j = n - 1;
        HashSet<Integer> usedH = new HashSet<>();
        int minUsedH = -1;
        while (i < j) {
            // Time limit:
            // for(int uh : usedH)
            // {
            //     while(i < j && h[i] <= uh) i++;
            //     while(i < j && h[j] <= uh) j--;
            // }
            // if(i > j) break;

            if (h[i] > minUsedH && h[j] > minUsedH) {
                minUsedH = Math.min(h[i], h[j]);
                maxArea = Math.max(maxArea, (j - i) * minUsedH);
            }
            if (h[i] == h[j]) {
                i++;
                j--;
            }
            else if (h[i] < h[j]) i++;
            else if (h[i] > h[j]) j--;
        }

        return maxArea;
    }
}
