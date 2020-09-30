import java.util.*;

// Video link https://youtu.be/ZmnqCZp9bBs for better understanding

public class maxRectangleInHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(maxHistArea(arr, n));
        }
    }

    static int maxHistArea(int[] h, int m)
    {
        // Stack: can be extendable clusters of h
        // push if can be extendable (>= top)
        // pop if not, we know we use the current idx of h as width, becuz we can extend
        Stack<Integer> stack = new Stack<>();
        int maxA = 0;
        int j = 0;
        while(j < m) {
            if (stack.isEmpty() || h[stack.peek()] <= h[j])
                stack.push(j++);
            else {
                int idx = stack.pop();
                maxA = Math.max(maxA, h[idx] * (stack.isEmpty() ? j : j - 1 - stack.peek()));
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            maxA = Math.max(maxA, h[idx] * (stack.isEmpty() ? j : j - 1 - stack.peek()));
        }

        return maxA;
    }
}