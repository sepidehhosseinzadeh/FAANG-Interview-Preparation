import java.util.*;

public class paintBoards {
        static int ERR = Integer.MAX_VALUE;
        static int[] board;
        static int[][][] memo;

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            while (t-- > 0) {
                int k = scan.nextInt();
                int n = scan.nextInt();
                board = new int[n];
                memo = new int[n][n][k + 1];
                for (int[][] a : memo)
                    for (int[] b : a)
                        Arrays.fill(b, -1);
                for (int i = 0; i < n; i++)
                    board[i] = scan.nextInt();
                int minTime = minTimeFinish(0, n - 1, k);
                System.out.println(minTime);
            }
        }

        public static int minTimeFinish(int lb, int ub, int k)
        {
            if (k == 1)
                return sum(lb, ub);
            if (lb == ub)
                return board[lb];
            if (lb > ub)
                return 0;
            if (memo[lb][ub][k] != -1)
                return memo[lb][ub][k];

            int minRes = ERR;
            for (int i = lb; i <= ub; i++) {
                int t1 = sum(lb, i);
                int rest = minTimeFinish(i + 1, ub, k - 1);
                minRes = Math.min(minRes, Math.max(t1, rest));
            }
            return memo[lb][ub][k] = minRes;

        }

        public static int sum(int i, int j)
        {
            int s = 0;
            for (int k = i; k <= j; s += board[k], k++) ;
            return s;
        }
}
/* Binary Search approach
    static int getMax(int arr[], int n)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    static int getSum(int arr[], int n)
    {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];
        return total;
    }
    static int numberOfPainters(int arr[], int n, int maxLen)
    {
        int total = 0, numPainters = 1;

        for (int i = 0; i < n; i++) {
            total += arr[i];

            if (total > maxLen) {
                total = arr[i];
                numPainters++;
            }
        }

        return numPainters;
    }

    static int partition(int arr[], int n, int k)
    {
        int lo = getMax(arr, n);
        int hi = getSum(arr, n);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);

            // find better optimum in lower half
            if (requiredPainters <= k)
                hi = mid;
            // required Painters > k, which is invalid
            else
                lo = mid + 1;
        }
        // required
        return lo;
    }
 */
