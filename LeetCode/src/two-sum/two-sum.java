class Solution {
    public int[] twoSum(int[] nums, int target) {
        var index = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(index.containsKey(target-nums[i])) { 
                return new int[]{index.get(target-nums[i]), i};
            }
            index.put(nums[i], i);
        }
        return new int[] {-1,-1};
    }
}