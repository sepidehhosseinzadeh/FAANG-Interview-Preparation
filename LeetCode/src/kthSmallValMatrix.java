import java.util.*;

public class kthSmallValMatrix {
    // klog(n)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int j = 0; j <= n - 1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

    //O(log(M)*(n+m)) M is max-min val
    public int kthSmallest_v1(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int lb = matrix[0][0], ub = matrix[n-1][m-1];
        while(lb < ub)
        {
            int mid = lb+(ub-lb)/2;
            int cnt = 0;
            int j = m-1;
            // O(n+m)
            for(int i = 0; i < n; i++)
            {
                while(j >= 0 && matrix[i][j] > mid) j--;
                cnt += j+1;
            }
            if(cnt < k) lb = mid+1;
            else ub = mid;
        }
        return lb;
    }
}