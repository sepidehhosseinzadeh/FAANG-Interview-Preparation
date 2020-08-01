import java.util.*;

public class minDiffS1S2 {
    // Given an array, the task is to divide it into
    // two sets S1 and S2 such that the absolute difference
    // between their sums is minimum.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.print(findMin(arr, n));
        }
    }

    static int findMin(int arr[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        boolean dp[][] = new boolean[n + 1][sum + 1];

        // 0 sum is possible with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= sum; j++)
            {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }

        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]==true
        // where j loops from sum/2 to 0
        for (int j = sum / 2; j >= 0; j--)
            if (dp[n][j] == true)
            {
                diff = sum - 2 * j;
                break;
            }
        return diff;
    }
}
