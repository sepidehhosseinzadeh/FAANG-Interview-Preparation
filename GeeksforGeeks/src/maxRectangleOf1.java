import java.util.*;

public class maxRectangleOf1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            System.out.println(maxArea(a, m, n));
        }
    }

    static int maxHist(int[] h, int m)
    {
        // max rec in histogram for each row
        Stack<Integer> stack = new Stack<>();
        int maxA = 0;
        int j = 0;
        for(; j < m; j++)
        {
            if(stack.isEmpty() || h[stack.peek()] <= h[j])
                stack.push(j);
            else
            {
                int idx = stack.pop();
                maxA = Math.max(maxA, h[idx]*(stack.isEmpty()?j:j-1-stack.peek()));
                j--;
            }
        }
        while(!stack.isEmpty())
        {
            int idx = stack.pop();
            maxA = Math.max(maxA, h[idx]*(stack.isEmpty()?j:j-1-stack.peek()));
        }

        return maxA;
    }
    static int maxArea(int M[][], int n, int m) {
        if(n == 0) return 0;

        int maxA = maxHist(M[0],m);

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                if(M[i][j] == 1)
                    M[i][j] += M[i-1][j];

            maxA = Math.max(maxA, maxHist(M[i], m));
        }


        return maxA;
    }
}