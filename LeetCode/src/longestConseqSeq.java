import java.util.*;

public class longestConseqSeq {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int i : nums) set.add(i);
        int n = nums.length;

        int maxLen = 0;
        for(int i = 0; i < n; i++)
            if(!set.contains(nums[i]-1)) { // start of a seq
                int at = nums[i], len = 0;
                while(set.contains(at)) {
                    len++;
                    at++;
                }
                maxLen = Math.max(len, maxLen);
            }
        return maxLen;

    }
}
