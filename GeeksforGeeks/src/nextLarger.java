import java.util.*;
/*
http://geeksforgeeks.org/next-greater-element/
Given an array A of size N having distinct elements,
the task is to find the next greater element for each element of the array
in order of their appearance in the array.
If no such element exists, output -1
 */
public class nextLarger {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            nextMax(arr, n);
            System.out.println();
        }
    }
    static void nextMax(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<Integer>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!s.isEmpty() && arr[i] > arr[s.peek()])
                res[s.pop()] = i;

            s.push(i);
        }
        while(!s.isEmpty()) res[s.pop()] = -1;

        for(int i : res) System.out.print((i==-1?-1:arr[i])+" ");

    }
}
