import java.util.*;

public class waysMakeFairArr {
    public int waysToMakeFair_v0(int[] nums) {
        int cnt = 0, n = nums.length;
        int[] s = new int[]{0,0};

        for(int i = 0; i < n; i++) s[i%2] += nums[i];

        for(int i = 0; i < n; i++)
        {
            s[i%2] -= nums[i];
            if(s[0] == s[1]) cnt++;
            s[(i+1)%2] += nums[i];
        }

        return cnt;
    }

    public int waysToMakeFair_v1(int[] nums) {
        int n = nums.length;
        int[] preOdd = new int[n];
        int[] preEven = new int[n];

        preEven[0] = nums[0];
        for(int i = 1; i < n; i++) {
            preOdd[i] += preOdd[i-1];
            preEven[i] += preEven[i-1];
            if(i%2 != 0) preOdd[i] += nums[i];
            else preEven[i] += nums[i];
        }

        int cnt = 0;
        for(int i = 0; i < n; i++)
            if((i>0?preEven[i-1]:0)+preOdd[n-1]-preOdd[i] == // shift even and odd after i
                    (i>0?preOdd[i-1]:0)+preEven[n-1]-preEven[i])
                cnt++;

        return cnt;
    }

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int remainingEven = 0, remainingOdd = 0;
        for(int i = 0; i < n; i++) {
            if(i%2 == 0) remainingEven += nums[i];
            else remainingOdd += nums[i];
        }
        int cnt = 0, currEven = 0, currOdd = 0;
        for(int i = 0; i < n; i++) {
            if(i%2 == 0) {
                remainingEven -= nums[i];
                if(currEven+remainingOdd == currOdd+remainingEven) cnt++;
                currEven += nums[i];
            } else {
                remainingOdd -= nums[i];
                if(currOdd+remainingEven == currEven+remainingOdd) cnt++;
                currOdd += nums[i];
            }
        }

        return cnt;
    }
}
