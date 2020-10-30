import java.util.*;

public class kthSmallest {
// PriorityQueue k times extract O(klogn)
// Quicksort partition O(n) on average (worst time O(n^2)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int k = sc.nextInt();

            System.out.println(kthSmall(arr, 0, n - 1, k));
        }
    }
    static int kthSmall(int[] arr, int l, int r, int k)
    {
        if (l > r || k > r - l + 1) return -1;
        int pivot = partition(arr, l, r);
        if (pivot == l + k - 1)
            return arr[pivot];
        else if (pivot < l + k - 1)
            return kthSmall(arr, pivot + 1, r, k - pivot + l - 1);
        return kthSmall(arr, l, pivot - 1, k);
    }

    public static int partition(int[] arr, int l,
                                int r)
    {
        int x = arr[r];
        int i = l;
        for (int j = l; j < r; j++)
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }

        swap(arr, i, r);
        return i;
    }

    static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}