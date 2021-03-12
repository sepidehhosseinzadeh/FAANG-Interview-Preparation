class Solution {
    // Sub-SEQUENCE: for each sums in second half,
    // find the closest t-s in second half such that s1+s2 ~ t
    public int minAbsDifference_v0(int[] nums, int t) {
        int n = nums.length;
        int[] nums1 = new int[n/2];
        int[] nums2 = new int[n-n/2];
        for(int i = 0; i < n/2; i++) nums1[i] = nums[i];
        for(int i = n/2; i < n; i++) nums2[i-n/2] = nums[i];
        
        var sums1 = new ArrayList<Integer>(); // 5,-7,-2
        var sums2 = new ArrayList<Integer>(); // 3,5,8
        
        dfs(0, 0, nums1, sums1);
        dfs(0, 0, nums2, sums2);
        
        TreeSet<Integer> st2 = new TreeSet();
        for(int s : sums2) st2.add(s);
        
        int min = Integer.MAX_VALUE;
        for(int s1 : sums1) {
            int s2 = t-s1; // find the closest to this 
            if(st2.first() <= s2)
                min = Math.min(min, Math.abs(s1+st2.floor(s2) - t));
            if(st2.last() >= s2)
                min = Math.min(min, Math.abs(s1+st2.ceiling(s2) - t));
        }
        
        return min;        
    }
    public int minAbsDifference(int[] nums, int t) {
        int n = nums.length;
        int[] nums1 = new int[n/2];
        int[] nums2 = new int[n-n/2];
        for(int i = 0; i < n/2; i++) nums1[i] = nums[i];
        for(int i = n/2; i < n; i++) nums2[i-n/2] = nums[i];
        
        var sums1 = new ArrayList<Integer>(); 
        var sums2 = new ArrayList<Integer>(); 
        
        dfs(0, 0, nums1, sums1);
        dfs(0, 0, nums2, sums2);
        
        Collections.sort(sums2);
        
        int min = Integer.MAX_VALUE;
        for(int s1 : sums1) {
            int s2 = t-s1; // find the closest to this 
            int i = Collections.binarySearch(sums2, s2);
            if(i >= 0) return 0; // exact match
            else i = -i-1;
            
            if(i>0) min = Math.min(min, Math.abs(s1+sums2.get(i-1) - t));
            if(i<sums2.size()) min = Math.min(min, Math.abs(s1+sums2.get(i) - t));
        }
        
        return min;        
    }
    
    void dfs(int at, int s, int[] nums, ArrayList<Integer> sums) {
        if(at == nums.length) {
            sums.add(s);
            return;
        }
        dfs(at+1, s, nums, sums); // dont include
        dfs(at+1, s+nums[at], nums, sums); // include
    }
    
    
    // minAbsDifferenceSUBARRAY to 0!!!!!
    public int minAbsDifference_SUBARRAY(int[] nums, int t) {
        int s = 0;
        int[] pre = new int[nums.length+1];
        pre[0] = 0;
        for(int i = 1; i <= nums.length; i++)
            pre[i] = pre[i-1]+nums[i-1];
        Arrays.sort(pre);
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < pre.length; i++) 
            min = Math.min(min, Math.abs(pre[i]-pre[i-1]));
          
        return min;
    }
    // minAbsDifferenceSUBARRAY to target!!!!!
    public int minAbsDifference_SUBARRAY_opt(int[] nums, int t) {
        int s = 0;
        TreeSet<Integer> pre = new TreeSet<>();
        pre.add(0);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            s += nums[i];
            int need = s-t; // need closest preSum to this
            if(pre.first() <= need) // check is exists <= o.w. Null pointer
                min = Math.min(min, Math.abs(s-pre.floor(need) - t));
            if(pre.last() >= need) 
                min = Math.min(min, Math.abs(s-pre.ceiling(need) - t));
            pre.add(s);
        }
          
        return min;
    }
}
