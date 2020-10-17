import java.util.*;

public class LongestSubArrSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println(longSubArrSumK(arr, n, k));
        }
    }

    static int longSubArrSumK(int[] arr, int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if (s == k)
                res = Math.max(res, i + 1);
            if (map.containsKey(s - k))
                res = Math.max(res, i - map.get(s - k));

            if (!map.containsKey(s))
                map.put(s, i);
        }
        return res;
    }
}