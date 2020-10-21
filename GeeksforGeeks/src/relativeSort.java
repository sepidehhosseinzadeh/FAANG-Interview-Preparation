import java.util.*;

public class relativeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++)
                b[i] = sc.nextInt();

            sort(a, b);
            System.out.println();
        }
    }
    static void sort(int[] a, int[] b)
    {
        int[] cnt = new int[(int) 1e6 + 1];
        for (int i : a) cnt[i]++;

        for (int i : b)
            while (cnt[i]-- > 0) System.out.print(i + " ");

        for (int i = 1; i < 1e6 + 1; i++)
            while (cnt[i]-- > 0) System.out.print(i + " ");
    }

    // What if this constraint 0 <= arr1[i], arr2[i] <= 1000 doesn't exist
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }
        for(int n : map.keySet()){
            for(int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }
}