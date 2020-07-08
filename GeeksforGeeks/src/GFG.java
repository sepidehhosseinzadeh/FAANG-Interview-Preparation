/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static long mod = (long)1e9+7;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int s = sc.nextInt();

            System.out.println(countSum(arr, new boolean[n], n, s));
        }
    }
    static long countSum(int[] arr, boolean[] vis, int n, int sum)
    {
        if(sum == 0)
            return 1;

        long cnt = 0;
        for(int i = 0; i < n; i++)
            if(!vis[i] && arr[i] <= sum)
            {
                vis[i] = true;
                cnt += countSum(arr, vis, n, sum-arr[i])%mod;
                vis[i] = false;
            }

        return cnt;
    }
}
