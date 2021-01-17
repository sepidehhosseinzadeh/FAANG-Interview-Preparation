class Solution {
    // idea is like the max rectangular in histogram.
    // for each line (a new pile added to prev line) 
    // +1 or 0 the heights till ith row. Sort them
    // By sorting, we know all h after h[i] is greater/equal
    // we can build a rectangular h[i]*(m-i)
    public int largestSubmatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] h = new int[m];
        int maxA = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) h[j] = 0;
                else h[j]++;;
            }
            int[] h1 = h.clone();
            Arrays.sort(h1);
            for(int j = 0; j < m; j++)
                maxA = Math.max(maxA, h1[j]*(m-j));
        }
        
        return maxA;
    }
}
