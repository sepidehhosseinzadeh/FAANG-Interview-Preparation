import java.util.*;

public class LonContiSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(LCS(arr));
        }
    }

    static int LCS(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        for (int i : arr) set.add(i);

        for (int i : arr) {
            if (set.contains(i) && !set.contains(i - 1)) {
                int j = i;
                while (set.contains(j)) j++;

                if (j - i > max) max = j - i;

            }
        }
        return max;
    }
}
