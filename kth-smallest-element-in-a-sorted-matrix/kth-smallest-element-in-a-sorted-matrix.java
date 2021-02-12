class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int lb  = mat[0][0], ub = mat[n-1][m-1];
        while(lb <=ub) {
            int mid = lb+(ub-lb)/2;
            
            int cnt = 0; // # of elem <= mid in each row
            for(int i = 0; i < n; i++) {  
                if(mat[i][0] > mid) break;
                cnt += bs(mat[i], mid);
            }
            // another way of counting
            // int j = m-1;
            // for(int i = 0; i < n; i++) {
            //     while(j>=0 && mat[i][j] > mid) j--;
            //     cnt += j+1;
            // }
            
            if(cnt < k) lb = mid+1;
            else ub = mid-1;
        }
        return lb;
    }
    private int bs(int[] v, int val) {
        int n = v.length;
  
        int lb = 0, ub = n-1;
        while(lb <= ub) {
            int mid = lb+(ub-lb)/2;
            if(v[mid] > val) ub = mid-1;
            else lb = mid+1;
        }
        
        return lb;
    } 
}
