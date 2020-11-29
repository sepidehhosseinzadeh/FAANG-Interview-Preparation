import java.util.*;

public class mountain {
    public static void main(String[] args)
    {
        System.out.print(minimumMountainRemovals(new int[]{9,8,1,7,6,5,4,3,2,1}));
    }

    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);

        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n-1; i >= 0; i--)
            for (int j = n-1; j > i; j--)
                if (nums[j] < nums[i])
                    lds[i] = Math.max(lds[i], lds[j] + 1);

        int res = nums.length;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, i+1-lis[i] + n-i-lds[i]);
        }
        return res;

    }
}
