import java.util.*;

public class threeSumSmaller {
    public static void main(String[] args) {
        System.out.print(threeSumSmaller(new int[]{-2,0,1,3},2));
    }
    public int threeSumSmaller_v0(int[] nums, int target) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);

        for(int i = 0; i+2 < n; i++)
        {
            int l = i+1, r = n-1;
            while(l < r)
                if(nums[i]+nums[l]+nums[r] < target) {
                    res += r-l;
                    l++;
                } else r--;
        }

        return res;
    }
    public static int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);

        for(int i = 0; i+2 < n; i++) // there must be 2 other nums
            for(int j = i+1; j+1 < n; j++) // there must be 1 other num after i
            {
                int ab = nums[i]+nums[j];

                // bs on upper bound
                int lb = j, ub = n-1; // j+1 is wrong!!! why? Becuz mid (res) is upper middle (+1)!!!!
                while(lb < ub)
                {
                    int mid = lb+(ub-lb+1)/2; // +1 becuz it goes to same mid!!! upper middle element instead of the lower middle element.
                    // Becuz to the terminating condition when there are two elements left
                    if(nums[mid] < target-ab)
                        lb = mid; // mid is also met the condition
                    else ub = mid-1;
                }

                res += lb-j;
            }
        return res;
    }
}