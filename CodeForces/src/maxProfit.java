import java.util.*;

public class maxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //sc.nextLine();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] coin = new long[n];
            for (int i = 0; i < n; i++)
                coin[i] = sc.nextLong();

            Arrays.sort(coin);

            long res = 0;
            for(long p : coin) {
                long cur = 0;
                for (int i = 0; i < n; i++)
                    if (coin[i] >= p)
                        cur += p;
                res = Math.max(res, cur);
            }
            System.out.println(res);
        }
    }
}
