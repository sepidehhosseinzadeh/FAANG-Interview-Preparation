import java.util.*;

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