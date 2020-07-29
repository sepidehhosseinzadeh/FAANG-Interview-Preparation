import java.util.*;

public class minMatMultCost {
    static char ch;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while(t-- > 0)
        {
            ch = 'A';
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            getMinMulti(arr, n);
        }
    }
    static int getMinMulti(int[] d, int n)
    {
        int[][] minMult = new int[n][n];
        int[][] braket = new int[n][n];
        for(int i = 0; i < n; i++)
            minMult[i][i] = 0;

        for(int l = 2; l < n; l++)
            for(int i = 1; i+l-1 < n; i++)
            {
                int j = i+l-1;
                int minCost = Integer.MAX_VALUE;
                for(int k = i; k < j; k++)
                {
                    int cost = minMult[i][k]+minMult[k+1][j]+
                            d[i-1]*d[k]*d[j];
                    if(cost < minCost)
                    {
                        minCost = cost;
                        braket[i][j] = k;
                    }
                }
                minMult[i][j] = minCost;
            }

        printbraket(1, n-1, braket);
        System.out.println();
        return minMult[1][n-1];
    }
    static void printbraket(int i, int j, int[][] braket)
    {
        if(i == j)
        {
            System.out.print(ch++);
            return;
        }
        System.out.print("(");

        printbraket(i, braket[i][j], braket);
        printbraket(braket[i][j]+1, j, braket);

        System.out.print(")");

    }
}
