import java.util.*;

public class minMovesComplementary {
    // TLE!!!!
    public int minMoves_v0(int[] nums, int limit) {
        var sum = new ArrayList<Integer>();
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n / 2; i++) sum.add(nums[i] + nums[n - i - 1]);
        for (int s : sum) {
            int move = 0;
            boolean ok = true;
            for (int i = 0; i < n / 2; i++) {
                if (nums[i] + nums[n - i - 1] > s) {
                    int d = nums[i] + nums[n - i - 1] - s;
                    if (nums[i] - d > 0 && nums[i] - d <= limit) move++;
                    else if (nums[n - i - 1] - d > 0 && nums[n - i - 1] - d <= limit) move++;
                    else if (nums[i] + nums[n - i - 1] - d > 0 && nums[i] + nums[n - i - 1] - d <= 2 * limit) move += 2;
                    else {
                        ok = false;
                        break;
                    }
                }
                else if (nums[i] + nums[n - i - 1] < s) {
                    int d = s - (nums[i] + nums[n - i - 1]);
                    if (nums[i] + d <= limit) move++;
                    else if (nums[n - i - 1] + d <= limit) move++;
                    else if (nums[i] + nums[n - i - 1] + d <= 2 * limit) move += 2;
                    else {
                        ok = false;
                        break;
                    }
                }
                if (!ok) break;
            }
            if (ok) min = Math.min(move, min);
        }
        return min;

    }
    /*
    By 2 moves we can get any number between [2, limit*2] (including move a number to the same number)
    After only one move (change one of the numbers to a number between 1 and limit)
    *The minimum sum we can get is (min(l, r) + 1) (let this be oneMoveMin)
    *The maximum sum we can get is (max(l, r) + limit) (let this be oneMoveMax)
    *We need no move to get (l + r) (let this be justGood)

    If we want to make the nums complementary, having all the pairs A = nums[i], B = nums[n - 1 - i] with A + B = T. Considering a pair A = nums[i], B = nums[n - 1 - i],
    there are 5 different situation for every such pair (A, B), given different target T.

    - 2 <= T < min(A, B) + 1, we need 2 operations to make both A, B smaller
    - min(A, B) + 1 <= T < A + B, we need 1 operation to make the larger one out of A and B smaller
    - T = A + B, we need 0 operation
    - A + B < T < max(A, B) + limit, we need 1 operation to make the smaller one out of A and B larger
    - max(A, B) + limit < T <= 2 * limit, we need 2 operation to make both A, B larger

    We calculate the boundary for each pair (A, B) and note down the corresponding operation changes as delta.
    delta[i] = x means we need x more operations when target T change from i - 1 to i.*/

    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int l = nums[i], r = nums[n - 1 - i];
            int min = Math.min(l, r), max = Math.max(l, r);
            delta[min + 1]--;
            delta[l + r]--;
            delta[l + r + 1]++;
            delta[max + limit + 1]++;
        }
        int minMove = n, curMove = n;
        for (int d : delta) {
            curMove += d;
            minMove = Math.min(minMove, curMove);
        }
        return minMove;
    }

}