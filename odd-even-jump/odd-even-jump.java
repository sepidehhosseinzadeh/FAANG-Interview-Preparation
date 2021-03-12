class Solution {
    // bug!!!
    public int oddEvenJumps_v0(int[] A) {
        int n = A.length;
        int[][] nextIdx = new int[2][n];
        
        for(int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE, imax = -1;
            int min = Integer.MAX_VALUE, imin = -1;
            for(int j = i+1; j < n; j++) {
                if((A[j] > A[i] || A[j] == A[i] && imax == -1) &&
                                (imax == -1 || max > A[j])) {
                    max = A[j]; imax = j;
                }
                if((A[j] < A[i] || A[j] == A[i] && imin == -1) &&
                                (imin == -1 || min < A[j])) {
                    min = A[j]; imin = j;
                }
            }
            nextIdx[0][i] = imin;
            nextIdx[1][i] = imax;
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) cnt += dfs(i, 1, nextIdx, n);
        
        return cnt;
    }
    int dfs(int at, int jType, int[][] nextIdx, int n) {
        if(at == n-1) return 1;
        if(at == -1) return 0;
        
        int j = nextIdx[jType][at];
        return dfs(j, 1-jType, nextIdx, n);
    }
    
    // Last position is 1
    // From each position we should know 
    // if the odd/even jump is possible or not
    // then alternatively 
    public int oddEvenJumps_v1(int[] A) {
        int n = A.length;
        boolean[] even = new boolean[n], odd = new boolean[n];
        even[n-1] = odd[n-1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);
        
        int cnt = 1;
        for(int i = n-2; i >= 0; i--) {
            Integer hi, lo;
            if(map.containsKey(A[i])) {
                hi = A[i]; lo = A[i];
            } else {
                hi = map.higherKey(A[i]); lo = map.lowerKey(A[i]);
            }
            if(lo != null) even[i] = odd[map.get(lo)];
            if(hi != null) odd[i] = even[map.get(hi)];
            if(odd[i]) cnt++;
            
            map.put(A[i], i);
        }
        return cnt;
    }
    
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] even = new boolean[n], odd = new boolean[n];
        even[n-1] = odd[n-1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);
        
        int cnt = 1;
        for(int i = n-2; i >= 0; i--) {
            Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
            if(lo != null) even[i] = odd[lo.getValue()];
            if(hi != null) odd[i] = even[hi.getValue()];
            if(odd[i]) cnt++;
            
            map.put(A[i], i);
        }
        return cnt;
    }
}
