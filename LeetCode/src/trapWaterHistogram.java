import java.util.*;

public class trapWaterHistogram {
    // dp
    public int trap_v0(int[] h) {
        int n = h.length;
        if(n == 0) return 0;

        int[] maxl = new int[n];
        int[] maxr = new int[n];
        maxl[0] = h[0];
        maxr[n-1] = h[n-1];
        for(int i = 1; i < n; i++) {
            maxl[i] = Math.max(maxl[i-1], h[i]);
            maxr[n-i-1] = Math.max(maxr[n-i], h[n-i-1]);
        }
        int res = 0;
        for(int i = 0; i < n; i++)
            res += Math.min(maxl[i], maxr[i])-h[i];

        return res;
    }

    // stack
    public int trap_v1(int[] h) {
        int n = h.length;
        var stack = new Stack<Integer>();
        int res = 0;
        for(int i = 0; i < n; i++) {
            // push while h_cur <= top, with a hope that we'll see a
            // bigger one to trap water.
            // when we see a bigger one, we know that prev h (top)
            // is trapped. h_cur (max_right) and h_before_top (max_left)
            // are trapping h_top.
            while(!stack.isEmpty() && h[stack.peek()] < h[i]) {
                int h_trapped = h[stack.pop()];
                if(stack.isEmpty()) break;
                int h_max_left = h[stack.peek()];
                int h_max_right = h[i];
                int H = Math.min(h_max_left, h_max_right)-h_trapped;
                int W = i-stack.peek()-1;
                res += H*W;
            }
            stack.push(i);
        }
        return res;
    }

    // two-pointer
    public int trap(int[] h) {
        int n = h.length;
        if(n <= 2) return 0;

        int i = 0, j = n-1;
        int maxl = h[0], maxr = h[n-1], res = 0;
        while(i < j) {
            if(h[i] <= h[j]) res += Math.min(maxl, maxr)-h[i++];
            else res += Math.min(maxl, maxr)-h[j--];
            maxl = Math.max(maxl, h[i]);
            maxr = Math.max(maxr, h[j]);
        }
        return res;
    }
}