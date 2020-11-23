import java.util.*;

public class smallestStr {
    public static void main(String[] args)
    {
        System.out.print(getSmallestString(96149,189223));
    }

    public static String getSmallestString_v0(int n, int k) {
        char[] res = new char[n];
        for (int i = 0; i < n; i++) res[i] = 'a'; // give all 'a'
        k -= n;
        for (int i = n - 1; i >= 0; i--) // start with the last position, and distribute the greatest remaining value 'z'...
        // why give biggest value to last position and previous positions? becuz we need to
        // have 'a' as much as possible...
        {
            int remain = Math.min(25, k); // 25 = y, y+a=z
            res[i] += remain;
            k -= remain;
        }

        return new String(res);
    }

    public static String getSmallestString(int n, int k)
    {
        int nY = (k - n) / 25;
        int atMostOneMoreCharVal = k - n - nY * 25;
        char[] res = new char[n];
        int i = 0;
        for (; i < nY; i++) res[n-i-1] = 'z';
        if (atMostOneMoreCharVal > 0) {
            res[n-1-i] = (char) (atMostOneMoreCharVal + 'a');
            i++;
        }
        for (; i < n; i++) res[n-i-1] = 'a';

        return new String(res);
    }
}
