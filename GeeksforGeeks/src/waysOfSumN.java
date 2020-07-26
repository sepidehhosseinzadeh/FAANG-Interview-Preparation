import java.util.*;
import java.lang.*;

// Generate all unique partitions of an integer
class waysOfSumN {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            int s = sc.nextInt();
            solve(1,s,s,new int[1000]);
        }
    }
    static void solve(int idx, int maxVal, int remSum, int[] dp)
    {
        if (remSum == 0)
        {
            for (int i = 1; i < idx; i++)
                System.out.print(dp[i] + " ");
            System.out.println("");
            return;
        }
        // if(idx == 1000) return;

        for (int i = maxVal; i >= 1; i--)
            if (i <= remSum)
            {
                dp[idx] = i;
                solve(idx + 1, i, remSum - i, dp);
            }
    }

}