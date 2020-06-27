// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;

    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
                arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            tmp g = new tmp();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}
// } Driver Code Ends

class tmp
{
    int maxChainLength(Pair arr[], int n)
    {
        if(n == 0)  return 0;
        if(n == 1)  return 1;

        Arrays.sort(arr, new Comparator<Pair>(){
            public int compare(Pair a, Pair b)
            {
                return a.x - b.x;
            }
        });

        int[] maxIfEnd = new int[n];
        Arrays.fill(maxIfEnd, 1);
        for(int i = 1; i < n; i++)
            for(int j = i-1; j >= 0; j--)
                if(arr[j].y < arr[i].x)
                    maxIfEnd[i] = Math.max(maxIfEnd[i], maxIfEnd[j]+1);

        return maxIfEnd[n-1];
    }
}