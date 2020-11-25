import java.lang.reflect.Array;
import java.util.*;

public class combinationSum {
    public static void main(String[] arg)
    {
        System.out.print(combinationSum(new int[]{2,3,6,7}, 7));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 0; j <= target; j++)
            for (int i = 0; i < n; i++)
                if (j >= nums[i])
                    dp[j] += dp[j - nums[i]];
        return dp[target];
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // for considering nums in ascending order for preventing repeation!
        var dp = new ArrayList<List<List<Integer>>>();

        for (int t = 0; t <= target; t++) {
            var dp_t = new ArrayList<List<Integer>>();
            for (int i = 0; i < n && t >= nums[i]; i++) {
                if(t == nums[i]) // dp.get(t-nums[i]).size() == 0) wrong! because dp will be  updated after a loop! and repeated numbers will be added!
                    dp_t.add(Arrays.asList(nums[i]));
                else for (List<Integer> prev : dp.get(t-nums[i]))
                    if(nums[i] <= prev.get(0)) { // make sure no repetition! consider nums asc! list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                        var cur = new ArrayList<Integer>(prev);
                        cur.add(0, nums[i]);
                        dp_t.add(cur);
                    }
                }
            dp.add(dp_t);
        }
        return dp.get(target);
    }
    public List<List<Integer>> combinationSum_v1(int[] candidates, int target) {
        // sort candidates to try them in asc order
        Arrays.sort(candidates);
        // dp[t] stores all combinations that add up to t
        List<List<Integer>>[] dp = new ArrayList[target+1];

        for(int t=0; t<=target; t++) {
            dp[t] = new ArrayList();
            List<List<Integer>> combList = new ArrayList();

            // for each t, find possible combinations
            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
                if(candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
                } else {
                    for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
                        // i thought it makes more sense to compare with the last element
                        // only add to list when the candidates[j] >= the last element
                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                        // equal is needed since we can choose the same element many times
                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                            List temp = new ArrayList(prevlist); // temp is needed since
                            temp.add(candidates[j]); // cannot edit prevlist inside 4each loop
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }

    // recursive
    public List<List<Integer>> combinationSum_v2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), nums, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int nums[], int target, int start){
        if(target > 0){
            for(int i = start; i < nums.length && target >= nums[i]; i++){
                cur.add(nums[i]);
                getResult(result, cur, nums, target - nums[i], i);
                cur.remove(cur.size() - 1);
            }
        } else if(target == 0){
            result.add(new ArrayList<Integer>(cur));
        }
    }
}

