import java.util.*;

public class intervalCnt {
    public static void main(String[] args)
    {
        System.out.print(carPooling(new int[][]{{4, 5, 6}, {6, 4, 7}, {4, 3, 5}, {2, 3, 5}}, 13));
    }

    public static boolean carPooling(int[][] tr, int cap) {
        int n = tr.length;
        if (n == 0) return true;
        if (n == 1) return tr[0][0] <= cap;

        TreeMap<Integer, Integer> trip = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            trip.put(tr[i][1], trip.getOrDefault(tr[i][1], 0) + tr[i][0]);
            trip.put(tr[i][2], trip.getOrDefault(tr[i][2], 0) - tr[i][0]);
        }

        int cur = 0;
        for (int t : trip.keySet()) {
            cur += trip.get(t);
            if (cur > cap) return false;
        }
        return true;

    }
}
