import java.util.*;

public class canJumpAcrossRiver {
    public static void main(String[] a)
    {
        System.out.print(minLength(1,1,1));
    }
    public static long minLength(int N, int M, int J)
    {
        long[] d = new long[N];
        long lb = -1, ub = 0;
        for (int j = 0; j < N; j++) {
            d[j] = getD(j, M);
            lb = Math.max(lb, d[j]);
            ub += d[j];
        }

        while (lb < ub) {
            long mid = lb + (ub - lb) / 2;
            if (!possible(d, mid, J)) lb = mid + 1;
            else ub = mid;
        }
        return lb;
    }

    static boolean possible(long[] d, long L, int J)
    {
        long dis = 0, j = 1;
        for (long len : d) {
            if (dis + len > L) {
                j++;
                dis = len;
            }
            else
                dis += len;
        }

        return j <= J;
    }

    static long getD(long i, int M)
    {
        return 1 + (i * i) % M;
    }
}
