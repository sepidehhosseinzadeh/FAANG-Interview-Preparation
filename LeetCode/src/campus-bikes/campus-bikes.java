class Solution {
    public int[] assignBikes(int[][] w, int[][] b) {
        int n = w.length, m = b.length;
        int[][] mah = new int[n*m][3]; // mah dis, w's idx, bike's idx
        for(int i = 0, k = 0; i < n; i++)
            for(int j = 0; j < m; j++) 
                mah[k++] = new int[] {mahDis(w[i], b[j]), i, j};
        
        Arrays.sort(mah, (i,j) -> i[0]!=j[0] ? i[0]-j[0] : 
                                        i[1]!=j[1] ? i[1]-j[1] : i[2]-j[2]);
        
        boolean[] taken = new boolean[m];
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        for(int r = 0; r < n*m; r++) 
            if(res[mah[r][1]] == -1 && !taken[mah[r][2]]) { 
                res[mah[r][1]] = mah[r][2];
                taken[mah[r][2]] = true;
            }
        
        return res;
    }
    int mahDis(int[] a, int[] b) {
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
