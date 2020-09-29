import java.util.*;

/*Given an array arr[] of N nodes representing preorder traversal of BST.
The task is to print its postorder traversal.
Example:
Input:
3
5
40 30 35 80 100
8
40 30 32 35 80 90 100 120

Output:
35 30 100 80 40
35 32 30 120 100 90 80 40
 */
public class printPostFromPreOrderBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            printPostfPre(arr, 0, arr.length - 1);
            System.out.println();
        }
    }

    static void printPostfPre(int[] arr, int l, int r)
    {
        if (l > r) return;
        if (l == r) {
            System.out.print(arr[l] + " ");
            return;
        }

        int mid = l;
        while (mid <= r && arr[mid] <= arr[l])
            mid++;

        printPostfPre(arr, l + 1, mid - 1);
        printPostfPre(arr, mid, r);

        System.out.print(arr[l] + " ");
    }
}