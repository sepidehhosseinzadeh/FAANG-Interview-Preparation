class Solution {
    public int majorityElement(int[] nums) {
        var cnt = new HashMap<Integer, Integer> ();
        
        for(int i : nums) {
            cnt.put(i, cnt.getOrDefault(i,0)+1);
            if(cnt.get(i) > nums.length/2) return i;
        }
        
        return -1;
    }
}
