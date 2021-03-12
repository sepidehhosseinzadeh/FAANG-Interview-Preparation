class Solution {
    int n;
    int[] w;
    public Solution(int[] w) {
        this.w = w;
        n = w.length;
        for(int i = 1; i < n; i++)
            w[i] += w[i-1];
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int idx = rand.nextInt(w[n-1])+1;
        return binarySearch(idx, w);
    }
    int binarySearch(int val, int[] v) {
        int lb = 0, ub = n-1;
        while(lb < ub) {
            int mid = lb + (ub-lb)/2;
            if(v[mid] == val) return mid;
            else if(v[mid] < val) lb = mid+1;
            else ub = mid;
        }
        return lb;
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
