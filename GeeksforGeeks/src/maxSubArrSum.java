import java.util.*;

public class maxSubArrSum {
    int maxSubarraySum(int arr[], int n) {
        int s = 0, res = arr[0];
        for(int i = 0 ; i < n; i++)
        {
            s+= arr[i];
            if(s < 0) s = 0;
            res = Math.max(res, s);
        }
        return res;
    }
}
