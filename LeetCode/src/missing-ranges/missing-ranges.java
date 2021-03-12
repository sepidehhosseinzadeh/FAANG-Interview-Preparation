class Solution {
    public List<String> findMissingRanges(int[] nums, int l, int r) {
        var res = new ArrayList<String>();
        int n = nums.length;
        
        if(n == 0) {res.add(l == r ? l+"" : l+"->"+r); return res;}
        
        if(nums[0]-l >= 1) res.add(nums[0]-l == 1 ? l+"": l+"->"+(nums[0]-1));
       
        int lb = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i]-lb > 1) 
                res.add(nums[i]-lb==2 ? (lb+1)+"": (lb+1)+"->"+(nums[i]-1));
            
            lb = nums[i];
        }
        
        if(r-lb >= 1) 
            res.add(r-lb==1 ? (lb+1)+"" : (lb+1)+"->"+r);
        
        return res;
    }
}